package com.resumebase.webapp.storage;

import com.resumebase.webapp.exception.ExistStorageException;
import com.resumebase.webapp.exception.NotExistStorageException;
import com.resumebase.webapp.exception.StorageException;
import com.resumebase.webapp.model.Resume;
import com.resumebase.webapp.sql.ConnectionFactory;
import com.resumebase.webapp.sql.SqlHelper;

import java.sql.*;
import java.util.List;

public class SqlStorage implements Storage{

    private final SqlHelper sqlHelper;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
    }

    @Override
    public void clear() {
        sqlHelper.execute("DELETE FROM resume");
    }

    @Override
    public Resume get(String uuid) {
        return sqlHelper.execute("SELECT * FROM resume r WHERE r.uuid=?", ps -> {
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()) {
                throw new NotExistStorageException(uuid);
            }
            return new Resume(uuid, rs.getString("full_name"));
        });
    }

    @Override
    public void save(Resume r) {
        sqlHelper.<Void>execute("INSERT INTO resume (uuid, full_name) VALUES (?,?)", ps -> {
            ps.setString(1, r.getUuid());
            ps.setString(2, r.getFullName());
            ps.executeQuery();
            return null;
        });
    }

    @Override
    public void update(Resume r) {
        //sqlHelper.execute("UPDATE resume SET full_name = ?, about = ? WHERE uuid")
    }


    @Override
    public List<Resume> getAllSorted() {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public int size() {
        return 0;
    }
}

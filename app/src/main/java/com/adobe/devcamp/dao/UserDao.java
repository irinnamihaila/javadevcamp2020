package com.adobe.devcamp.dao;

import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.model.Publisher;
import com.adobe.devcamp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    private final Logger logger = LoggerFactory.getLogger(UserDao.class);
    private final Connection connection;
    private static final Map<Class, String> TABLES = new HashMap<>();
    static {
        TABLES.put(User.class, "users");
        TABLES.put(Advertiser.class, "advertisers");
        TABLES.put(Campaign.class, "campaigns");
        TABLES.put(Publisher.class, "publishers");
    }

    public UserDao(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    public Map<Integer, String> selectAll(){
        Map<Integer, String> all = new HashMap<>();
        final String query = "SELECT * FROM " + TABLES.get(User.class);
        try{
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                all.put(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch(SQLException exception){
            logger.error("Query {} failed because {}", query, exception.getMessage());
        }

        return all;
    }
}

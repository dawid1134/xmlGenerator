package com.dwieczorek.studia.integracjasystemow.dao;

import com.dwieczorek.studia.integracjasystemow.dao.dto.MockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dawid on 29.10.2016.
 */
@Component
public class MockDataDao {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
        dataSource.setInitialSize(3);
        dataSource.setMaxActive(3);
        this.dataSource = dataSource;
    }

    public List<MockData> getAllData() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_data");
            ResultSet resultSet = callableStatement.executeQuery();
            List<MockData> mockDatas = new ArrayList<>();
            while (resultSet.next()) {
                MockData mockData = mapToMockData(resultSet);
                mockDatas.add(mockData);
            }
            return mockDatas;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public List<MockData> selectAllIdFirstLastName() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_id_first_last_name");
            ResultSet resultSet = callableStatement.executeQuery();
            List<MockData> mockDatas = new ArrayList<>();
            while (resultSet.next()) {
                MockData mockData = new MockData();
                mockData.setId(resultSet.getString("id"));
                mockData.setFirstName(resultSet.getString("first_name"));
                mockData.setLastName(resultSet.getString("last_name"));
                mockDatas.add(mockData);
            }
            return mockDatas;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public List<MockData> selectFirstLastNames() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_first_last_names");
            ResultSet resultSet = callableStatement.executeQuery();
            List<MockData> mockDatas = new ArrayList<>();
            while (resultSet.next()) {
                MockData mockData = new MockData();
                mockData.setFirstName(resultSet.getString("first_name"));
                mockData.setLastName(resultSet.getString("last_name"));
                mockDatas.add(mockData);
            }
            return mockDatas;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public List<MockData> selectAllFilteredByPhone(String phoneNumber) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_filter_phone(?)");
            callableStatement.setString(1, phoneNumber);
            ResultSet resultSet = callableStatement.executeQuery();
            List<MockData> mockDatas = new ArrayList<>();
            while (resultSet.next()) {
                MockData mockData = mapToMockData(resultSet);
                mockDatas.add(mockData);
            }
            return mockDatas;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public List<MockData> selectAllFilteredByLastName(String lastName) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_filter_last_name(?)");
            callableStatement.setString(1, lastName);
            ResultSet resultSet = callableStatement.executeQuery();
            List<MockData> mockDatas = new ArrayList<>();
            while (resultSet.next()) {
                MockData mockData = mapToMockData(resultSet);
                mockDatas.add(mockData);
            }
            return mockDatas;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public List<MockData> selectAllFilteredByFirstName(String firstName) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_filter_first_name(?)");
            callableStatement.setString(1, firstName);
            ResultSet resultSet = callableStatement.executeQuery();
            List<MockData> mockDatas = new ArrayList<>();
            while (resultSet.next()) {
                MockData mockData = mapToMockData(resultSet);
                mockDatas.add(mockData);
            }
            return mockDatas;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public List<MockData> selectAllDataLimited(Integer limit, Integer offset) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_data_limited(?,?)");
            callableStatement.setInt(1, limit);
            callableStatement.setInt(2, offset);
            ResultSet resultSet = callableStatement.executeQuery();
            List<MockData> mockDatas = new ArrayList<>();
            while (resultSet.next()) {
                MockData mockData = mapToMockData(resultSet);
                mockDatas.add(mockData);
            }
            return mockDatas;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public List<MockData> selectAllFilteredByFirstAndLastName(String firstName, String lastName) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_filter_first_last_name(?,?)");
            callableStatement.setString(1, firstName);
            callableStatement.setString(2, lastName);
            ResultSet resultSet = callableStatement.executeQuery();
            List<MockData> mockDatas = new ArrayList<>();
            while (resultSet.next()) {
                MockData mockData = mapToMockData(resultSet);
                mockDatas.add(mockData);
            }
            return mockDatas;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public List<MockData> selectAllFilteredByPhoneLimited(String phone, Integer limit, Integer offset) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_filter_phone_limited(?,?,?)");
            callableStatement.setString(1, phone);
            callableStatement.setInt(2, limit);
            callableStatement.setInt(3, offset);
            ResultSet resultSet = callableStatement.executeQuery();
            List<MockData> mockDatas = new ArrayList<>();
            while (resultSet.next()) {
                MockData mockData = mapToMockData(resultSet);
                mockDatas.add(mockData);
            }
            return mockDatas;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public List<MockData> selectAllIdFirstLastNameLimited(Integer limit, Integer offset) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_id_first_last_name_limited(?,?)");
            callableStatement.setInt(1, limit);
            callableStatement.setInt(2, offset);
            ResultSet resultSet = callableStatement.executeQuery();
            List<MockData> mockDatas = new ArrayList<>();
            while (resultSet.next()) {
                MockData mockData = new MockData();
                mockData.setId(resultSet.getString("id"));
                mockData.setFirstName(resultSet.getString("first_name"));
                mockData.setLastName(resultSet.getString("last_name"));
                mockDatas.add(mockData);
            }
            return mockDatas;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    private MockData mapToMockData(ResultSet resultSet) throws SQLException {
        MockData mockData = new MockData();
        mockData.setId(resultSet.getString("id"));
        mockData.setFirstName(resultSet.getString("first_name"));
        mockData.setLastName(resultSet.getString("last_name"));
        mockData.setEmail(resultSet.getString("email"));
        mockData.setGender(resultSet.getString("gender"));
        mockData.setIpAddress(resultSet.getString("ip_address"));
        mockData.setAppName(resultSet.getString("app_name"));
        mockData.setBitcoinAddress(resultSet.getString("bitcoin_address"));
        mockData.setCity(resultSet.getString("city"));
        mockData.setCountry(resultSet.getString("country"));
        mockData.setDomain(resultSet.getString("domain"));
        mockData.setHexColor(resultSet.getString("hex_color"));
        mockData.setPhone(resultSet.getString("phone"));
        mockData.setTime(resultSet.getString("time"));
        mockData.setTitle(resultSet.getString("title"));
        return mockData;
    }
}

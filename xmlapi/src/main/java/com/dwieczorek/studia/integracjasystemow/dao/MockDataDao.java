package com.dwieczorek.studia.integracjasystemow.dao;

import com.dwieczorek.studia.integracjasystemow.dao.dto.CustomerData;
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

    @Autowired
    private DataSource dataSource;

    public List<CustomerData> getAllData() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_data");
            ResultSet resultSet = callableStatement.executeQuery();
            List<CustomerData> customerDatas = new ArrayList<>();
            while (resultSet.next()) {
                CustomerData customerData = mapToMockData(resultSet);
                customerDatas.add(customerData);
            }
            return customerDatas;
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

    public List<CustomerData> selectAllIdFirstLastName() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_id_first_last_name");
            ResultSet resultSet = callableStatement.executeQuery();
            List<CustomerData> customerDatas = new ArrayList<>();
            while (resultSet.next()) {
                CustomerData customerData = new CustomerData();
                customerData.setId(resultSet.getString("id"));
                customerData.setFirstName(resultSet.getString("first_name"));
                customerData.setLastName(resultSet.getString("last_name"));
                customerDatas.add(customerData);
            }
            return customerDatas;
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

    public List<CustomerData> selectFirstLastNames() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_first_last_names");
            ResultSet resultSet = callableStatement.executeQuery();
            List<CustomerData> customerDatas = new ArrayList<>();
            while (resultSet.next()) {
                CustomerData customerData = new CustomerData();
                customerData.setFirstName(resultSet.getString("first_name"));
                customerData.setLastName(resultSet.getString("last_name"));
                customerDatas.add(customerData);
            }
            return customerDatas;
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

    public List<CustomerData> selectAllFilteredByPhone(String phoneNumber) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_filter_phone(?)");
            callableStatement.setString(1, phoneNumber);
            ResultSet resultSet = callableStatement.executeQuery();
            List<CustomerData> customerDatas = new ArrayList<>();
            while (resultSet.next()) {
                CustomerData customerData = mapToMockData(resultSet);
                customerDatas.add(customerData);
            }
            return customerDatas;
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

    public List<CustomerData> selectAllFilteredByLastName(String lastName) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_filter_last_name(?)");
            callableStatement.setString(1, lastName);
            ResultSet resultSet = callableStatement.executeQuery();
            List<CustomerData> customerDatas = new ArrayList<>();
            while (resultSet.next()) {
                CustomerData customerData = mapToMockData(resultSet);
                customerDatas.add(customerData);
            }
            return customerDatas;
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

    public List<CustomerData> selectAllFilteredByFirstName(String firstName) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_filter_first_name(?)");
            callableStatement.setString(1, firstName);
            ResultSet resultSet = callableStatement.executeQuery();
            List<CustomerData> customerDatas = new ArrayList<>();
            while (resultSet.next()) {
                CustomerData customerData = mapToMockData(resultSet);
                customerDatas.add(customerData);
            }
            return customerDatas;
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

    public List<CustomerData> selectAllDataLimited(Integer limit, Integer offset) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_data_limited(?,?)");
            callableStatement.setInt(1, limit);
            callableStatement.setInt(2, offset);
            ResultSet resultSet = callableStatement.executeQuery();
            List<CustomerData> customerDatas = new ArrayList<>();
            while (resultSet.next()) {
                CustomerData customerData = mapToMockData(resultSet);
                customerDatas.add(customerData);
            }
            return customerDatas;
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

    public List<CustomerData> selectAllFilteredByFirstAndLastName(String firstName, String lastName) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_filter_first_last_name(?,?)");
            callableStatement.setString(1, firstName);
            callableStatement.setString(2, lastName);
            ResultSet resultSet = callableStatement.executeQuery();
            List<CustomerData> customerDatas = new ArrayList<>();
            while (resultSet.next()) {
                CustomerData customerData = mapToMockData(resultSet);
                customerDatas.add(customerData);
            }
            return customerDatas;
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

    public List<CustomerData> selectAllFilteredByPhoneLimited(String phone, Integer limit, Integer offset) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_filter_phone_limited(?,?,?)");
            callableStatement.setString(1, phone);
            callableStatement.setInt(2, limit);
            callableStatement.setInt(3, offset);
            ResultSet resultSet = callableStatement.executeQuery();
            List<CustomerData> customerDatas = new ArrayList<>();
            while (resultSet.next()) {
                CustomerData customerData = mapToMockData(resultSet);
                customerDatas.add(customerData);
            }
            return customerDatas;
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

    public List<CustomerData> selectAllIdFirstLastNameLimited(Integer limit, Integer offset) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            CallableStatement callableStatement = conn.prepareCall("call select_all_id_first_last_name_limited(?,?)");
            callableStatement.setInt(1, limit);
            callableStatement.setInt(2, offset);
            ResultSet resultSet = callableStatement.executeQuery();
            List<CustomerData> customerDatas = new ArrayList<>();
            while (resultSet.next()) {
                CustomerData customerData = new CustomerData();
                customerData.setId(resultSet.getString("id"));
                customerData.setFirstName(resultSet.getString("first_name"));
                customerData.setLastName(resultSet.getString("last_name"));
                customerDatas.add(customerData);
            }
            return customerDatas;
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


    private CustomerData mapToMockData(ResultSet resultSet) throws SQLException {
        CustomerData customerData = new CustomerData();
        customerData.setId(resultSet.getString("id"));
        customerData.setFirstName(resultSet.getString("first_name"));
        customerData.setLastName(resultSet.getString("last_name"));
        customerData.setEmail(resultSet.getString("email"));
        customerData.setGender(resultSet.getString("gender"));
        customerData.setIpAddress(resultSet.getString("ip_address"));
        customerData.setAppName(resultSet.getString("app_name"));
        customerData.setBitcoinAddress(resultSet.getString("bitcoin_address"));
        customerData.setCity(resultSet.getString("city"));
        customerData.setCountry(resultSet.getString("country"));
        customerData.setDomain(resultSet.getString("domain"));
        customerData.setHexColor(resultSet.getString("hex_color"));
        customerData.setPhone(resultSet.getString("phone"));
        customerData.setTime(resultSet.getString("time"));
        customerData.setTitle(resultSet.getString("title"));
        return customerData;
    }
}

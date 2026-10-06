package com.example.bai_tap.repository.product;

import com.example.bai_tap.dto.ProductDto;
import com.example.bai_tap.entity.Product;
import com.example.bai_tap.untils.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String SELECT_ALL = "select p.*,c.name as category from products p join categories c on p.id_category = c.id order by p.id asc;";
    private final String FIND_BY_CATEGORY_ID = "select p.*,c.name as category from products p join categories c on p.id_category = c.id where p.id_category = ? order by p.id asc;";
    private final String SELECT_PRODUCT_PAGE = "select p.*,c.name as category from products p join categories c on p.id_category = c.id order by p.id asc limit ? offset ?;";
    private final String COUNT_PRODUCTS = "select count(*) from products";
    private final String SEARCH_BY_NAME = "call search_by_name(?)";
    private final String INSERT_INTO = "insert into products(name,price,description,id_category) values (?,?,?,?);";
    private final String UPDATE = "UPDATE products SET name = ?, price = ?, description = ?, id_category = ? WHERE id = ?;";
    private final String DELETE = "delete from products where id =?;";

    @Override
    public List<ProductDto> findAll() {
        Connection connection = ConnectDB.getConnectDB();
        List<ProductDto> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productList.add(getProductFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<ProductDto> findByCategoryId(int categoryId) {
        Connection connection = ConnectDB.getConnectDB();
        List<ProductDto> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_CATEGORY_ID);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productList.add(getProductFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<ProductDto> findByPage(int page, int pageSize) {
        Connection connection = ConnectDB.getConnectDB();
        List<ProductDto> productList = new ArrayList<>();
        int offset = (page - 1) * pageSize;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_PAGE);
            preparedStatement.setInt(1, pageSize);
            preparedStatement.setInt(2, offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productList.add(getProductFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public int getTotalProducts() {
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(COUNT_PRODUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public List<ProductDto> searchByName(String name) {
        Connection connection = ConnectDB.getConnectDB();
        List<ProductDto> productList = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH_BY_NAME);
            callableStatement.setString(1, name);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                productList.add(getProductFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    private ProductDto getProductFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        double price = resultSet.getDouble("price");
        String description = resultSet.getString("description");
        String category = resultSet.getString("category");
        return new ProductDto(id, name, price, description, category);
    }

    @Override
    public boolean addProduct(Product product) {
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getId_category());
            int rowEffect = preparedStatement.executeUpdate();
            return rowEffect == 1;
        } catch (SQLException e) {
            System.out.println("lỗi DB");
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getId_category());
            preparedStatement.setInt(5, product.getId());
            int rowEffect = preparedStatement.executeUpdate();
            return rowEffect == 1;
        } catch (SQLException e) {
            System.out.println("lỗi DB");
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            int rowEffect = preparedStatement.executeUpdate();
            return rowEffect == 1;
        } catch (SQLException e) {
            System.out.println("lỗi DB");
        }
        return false;
    }
}

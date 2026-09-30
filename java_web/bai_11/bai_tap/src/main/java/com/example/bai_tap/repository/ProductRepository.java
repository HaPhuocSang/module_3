package com.example.bai_tap.repository;

import com.example.bai_tap.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iPhone 17 Pro Max", 34990000, "iPhone 17 Pro Max với thiết kế cao cấp, camera chuyên nghiệp và hiệu năng mạnh mẽ."));
        productList.add(new Product(2, "iPhone 16 Pro", 28990000, "iPhone 16 Pro sở hữu màn hình Super Retina XDR, chip A18 Pro và camera chất lượng cao."));
        productList.add(new Product(3, "Samsung Galaxy S25 Ultra", 33990000, "Samsung Galaxy S25 Ultra với màn hình Dynamic AMOLED, camera ấn tượng và hiệu năng mạnh."));
        productList.add(new Product(4, "Samsung Galaxy S25+", 26990000, "Galaxy S25+ có thiết kế hiện đại, màn hình lớn và hiệu năng mạnh mẽ."));
        productList.add(new Product(5, "Xiaomi 15 Ultra", 24990000, "Xiaomi 15 Ultra nổi bật với camera cao cấp, hiệu năng mạnh và màn hình sắc nét."));
        productList.add(new Product(6, "OPPO Find X8 Pro", 29990000, "OPPO Find X8 Pro có thiết kế sang trọng, camera Hasselblad và thời lượng pin tốt."));
        productList.add(new Product(7, "Google Pixel 9 Pro", 23990000, "Google Pixel 9 Pro nổi bật với camera thông minh và trải nghiệm Android thuần túy."));
        productList.add(new Product(8, "OnePlus 13", 21990000, "OnePlus 13 có hiệu năng cao, màn hình đẹp và thiết kế hiện đại."));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean addProduct(Product product) {
        return productList.add(product);
    }

    @Override
    public boolean updateProduct(int index, Product product) {
        return productList.set(index, product) != null;
    }

    @Override
    public boolean deleteProduct(int index) {
        return productList.remove(index) != null;
    }
}

public class Repository {
    private Product[] products = new Product[0];

    public void add(Product product){
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public  void removeById(int removeId) {
        Product removeProduct = findById(removeId);
        if (removeProduct == null) {
            throw new NotFoundException(removeId);
        }

        Product[] tmp = new Product[products.length - 1];

        int i = 0;
        for (Product product : products) {
            if (product.getId() != removeId) {
                tmp[i] = product;
                i++;
            }
        }
        products = tmp;
    }

    private Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}

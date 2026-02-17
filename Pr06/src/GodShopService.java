public class GodShopService {
    // TODO: split responsibilities into separate services.

    public void addProduct(String name, double price) {
    }
}

class ShopUserService {

    public void registerUser(String email) {
    }
}

class ShopOrderService {

    public void createOrder(String userEmail, String productName) {
    }

    public void payOrder(long orderId) {
    }
}

class ShopReportingService {

    public void exportReport(String fromDate, String toDate) {
    }
}

class ShopNotificationService {
    public void sendEmail(String email, String message) {
    }
}
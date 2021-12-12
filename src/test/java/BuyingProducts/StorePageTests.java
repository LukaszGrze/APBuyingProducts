package BuyingProducts;

import org.junit.Assert;
import org.junit.Test;

public class StorePageTests extends StorePageBase{

    @Test
    public void buyingProduct() {
        authenticationPage = mainPage.signIn();
        myAccountPage = authenticationPage.logIn(email, password);
        Assert.assertEquals(userName, myAccountPage.checkUser());
        mainPage = myAccountPage.goToMainPage();
        womenPage = mainPage.goToWomenPage();
        printedDressPage = womenPage.goToPrintedDressPage();
        printedDressPage.selectQuantityAndSize(pdQuantity, pdSize);
        cartPage = printedDressPage.addToCart();
        printedDressPage = cartPage.continueShopping();
        womenPage = printedDressPage.goToWomenPage();
        printedSummerDressPage = womenPage.goToPrintedSummerDressPage();
        Assert.assertEquals(psdExpectedDiscount, printedSummerDressPage.checkDiscount());
        Assert.assertNotEquals(printedSummerDressPage.checkCurrent(), printedSummerDressPage.checkRegular());
        printedSummerDressPage.selectQuantitySizeColor(psdQuantity, psdSize);
        cartPage = printedSummerDressPage.addToCard();
        checkoutPage = cartPage.goToCheckoutPage();
        checkoutPage.buyProcedure(comment);
        Assert.assertEquals(pdExpectedName, checkoutPage.pdCheckName());
        Assert.assertEquals(pdExpectedPrintedDressColourAndSize, checkoutPage.pdCheckColourAndSize());
        Assert.assertEquals(pdExpectedUnitPrice, checkoutPage.pdCheckUnitPrice());
        Assert.assertEquals(pdQuantity, checkoutPage.pdCheckUnitQuantity());
        Assert.assertEquals(pdExpectedTotalProductPrice, checkoutPage.pdCheckTotalProductPrice());
        Assert.assertEquals(psdExpectedName, checkoutPage.psdCheckName());
        Assert.assertEquals(psdExpectedPrintedDressColourAndSize, checkoutPage.psdCheckColourAndSize());
        Assert.assertEquals(psdExpectedUnitPrice, checkoutPage.psdCheckUnitPrice());
        Assert.assertEquals(psdQuantity, checkoutPage.psdCheckUnitQuantity());
        Assert.assertEquals(psdExpectedTotalProductPrice, checkoutPage.psdCheckTotalProductPrice());
        Assert.assertEquals(expectedTotalPriceOfProducts, checkoutPage.checkTotalProductsPrice());
        Assert.assertEquals(expectedTotalShipping, checkoutPage.checkTotalShipping());
        Assert.assertEquals(expectedTotalPriceOfProductsWithShipment, checkoutPage.checkTotalPrice());
        checkoutPage.payByWireAndLogout();
        Assert.assertEquals(expectedSignInButtonText,authenticationPage.checkIfSignOut());
    }
}

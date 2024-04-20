import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class FoodOrderingSystem {

    double [] dblTotal = new double[10];
    double [] dblTotal2 = new double[10];

    /*================== Receipt User Information ==================*/
    String strName;
    String strConts;
    String strAddress;
    /*================== Restaurant A  Prices ==================*/
    int [] intPizza = new int[10];
    int [] intIce = new int[10];
    double [] dblCPizza = new double[10];
    double [] dblCIce = new double [10];

    double dblTotalP, dblTotalI;

    double dblPriceHawaiian = 100.50;
    double dblPriceHam = 150;
    double dblPriceCheese = 110.50;
    double dblPriceMeat = 200.00;
    double dblPricePep = 160.25;
    double dblDelCha = 40.00;
    double dblPriceVanilla = 15;
    double dblPriceChocolate = 15;
    double dblPriceStraw = 25;
    double dblPriceMango = 20;
    double dblPriceUbe = 30;
    double dblAmount = 0;

    /*================== Restaurant B Prices ==================*/
    double [] dblCMeal = new double [10];
    double [] dblCDrink = new double [10];
    int [] intMeal = new int[10];
    int [] intDrink = new int[10];

    double dblTotalM, dblTotalD;

    double dblPriceTapsi = 70;
    double dblPriceLongsi = 60;
    double dblPriceHotsi = 55;
    double dblPriceCornsi = 55;
    double dblPriceTosi = 65;
    double dblPriceTea = 40;
    double dblPriceCoke = 30;
    double dblPriceSprite = 30;
    double dblPriceJuice = 45;
    double dblPriceLemon = 50;
    double dblDelCha2 = 40.00;
    double dblAmount2 = 0;

    FoodOrderingSystem() {
        JFrame frmWindow = new JFrame ("Food Ordering System");
        JPanel panelUser = new JPanel();	//user info panel
        JPanel panelMenu3 = new JPanel();	//order panel
        JPanel panelResto = new JPanel();	//restaurant panel
        JPanel panelA = new JPanel();		//restaurant A
        JPanel panelB = new JPanel();		//restaurant B

        /*================== 1st and 2nd Panels (User, Restaurants Available, Order) ==================*/
        JPanel panelMenu = new JPanel();
        panelMenu.setBounds(0, 0, 600, 40);
        panelMenu.setBackground(Color.LIGHT_GRAY);

        JButton btnUser = new JButton("User Profile");
        JButton btnResto = new JButton("Restaurants Available");
        JButton btnOrder = new JButton("Order");

        JPanel panelMenu2 = new JPanel();
        panelMenu2.setBounds(0, 0, 1000, 700);
        panelMenu2.setBackground(Color.LIGHT_GRAY);

        JComboBox cboResto;
        String[] objResto;
        objResto = new String[] {" ", "Slices and Scoops", "Busolved"};
        cboResto = new JComboBox(objResto);


        JLabel lblResto = new JLabel("Select your Restaurant");

        /*================== USER PROFILE ==================*/
        JTextArea taTerms= new JTextArea("Privacy Policy\n" +
                "Updated at 2022-02-25\n" +
                "\nFOS is committed to protecting your privacy. This Privacy Policy explains how your personal information is collected," +
                "used, and diclosed by FOS. This Privacy Policy applies to our application named SYMS, and its associated subdomains" +
                "(collectively, our \"Service\"). By accessing or using our Service, you signify that you have " +
                "read, understood, and agree to our collection, storage, use, and disclosure of your personal information as described in this Privacy " +
                "Policy and our Terms of Service.",100,100);
        taTerms.setLineWrap(true);
        taTerms.setBounds(500, 230, 300, 200);
        JScrollPane sp = new JScrollPane(taTerms,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(170, 260, 50, 30);
        JTextField txtName;
        txtName = new JTextField(10);
        txtName.setBounds(260, 260, 200, 30);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(170, 360, 80, 30);
        JTextArea taAddress = new JTextArea();
        taAddress.setBounds(260, 355, 200, 60);

        JLabel lblConInfo = new JLabel("Contact Info:");
        lblConInfo.setBounds(170, 310, 100, 30);
        JTextField txtConInfo;
        txtConInfo = new JTextField(10);
        txtConInfo.setBounds(260, 310, 200, 30);

        JButton btnEdit;
        btnEdit = new JButton("Edit");
        btnEdit.setBounds(350, 490, 100, 30);
        JButton btnSend;
        btnSend = new JButton("Send");
        btnSend.setBounds(480, 490, 100, 30);

        JCheckBox cbTerms;
        cbTerms= new JCheckBox ("Accept Terms And conditions");
        cbTerms.setBounds(500, 440, 200, 30);

        JLabel lblImage = new JLabel("");
        lblImage.setBounds(295, 90, 130, 130);
        Image imgIcon = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
		Image imgIcon2 = imgIcon.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgIcon2);
		lblImage.setIcon(scaledIcon);

    //Buttons disabled
        btnSend.setEnabled(false);
        btnOrder.setEnabled(false);
        
        /*================== Restaurants Available Button ==================*/
        JLabel lblSlices = new JLabel("");
        lblSlices.setBounds(90, 100, 350, 350);
        Image imgSlices = new ImageIcon(this.getClass().getResource("/slices.png")).getImage();
		Image imgSlices2 = imgSlices.getScaledInstance(lblSlices.getWidth(), lblSlices.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledSlices = new ImageIcon(imgSlices2);
		lblSlices.setIcon(scaledSlices);
		
		JLabel lblBusolved = new JLabel("");
        lblBusolved.setBounds(550, 100, 350, 350);
        Image imgBusolved = new ImageIcon(this.getClass().getResource("/busolved.png")).getImage();
		Image imgBusolved2 = imgBusolved.getScaledInstance(lblBusolved.getWidth(), lblBusolved.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledBusolved = new ImageIcon(imgBusolved2);
		lblBusolved.setIcon(scaledBusolved);
		
		JLabel lblSlicesdes = new JLabel("<html>Open every weekdays @ 8:00 AM - 8:00 PM<br/>"
				+ "Open every weekends @ 8:00 - 10:00 PM<br/>"
				+ "Contact No.: *101-17-15<html>");
		lblSlicesdes.setFont(new Font("Courier", Font.BOLD, 16));
		lblSlicesdes.setBounds(90, 250, 500, 500);
		
		JLabel lblBusolveddes = new JLabel("<html>Open every weekdays and weekends 24/7!<br/>"
				+ "Contact No.: #1500<html>");
		lblBusolveddes.setFont(new Font("Courier", Font.BOLD, 16));
		lblBusolveddes.setBounds(550, 235, 500, 500);
		
		JLabel lblFos = new JLabel("");
        lblFos.setBounds(5, 50, 1000, 600);
        Image imgFos = new ImageIcon(this.getClass().getResource("/fos.png")).getImage();
		Image imgFos2 = imgFos.getScaledInstance(lblFos.getWidth(), lblFos.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledFos = new ImageIcon(imgFos2);
		lblFos.setIcon(scaledFos);
        
        /*================== Images for Order Button ==================*/
        JLabel lblSlicesmenu = new JLabel("");
        lblSlicesmenu.setBounds(100, 100, 370, 520);
        Image imgSlicesmenu = new ImageIcon(this.getClass().getResource("/slicesmenu.png")).getImage();
		Image imgSlicesmenu2 = imgSlicesmenu.getScaledInstance(lblSlicesmenu.getWidth(), lblSlicesmenu.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledSlicesmenu = new ImageIcon(imgSlicesmenu2);
		lblSlicesmenu.setIcon(scaledSlicesmenu);
		
		JLabel lblBusolvedmenu = new JLabel("");
        lblBusolvedmenu.setBounds(510, 100, 370, 520);
        Image imgBusolvedmenu = new ImageIcon(this.getClass().getResource("/busolvedmenu.png")).getImage();
		Image imgBusolvedmenu2 = imgBusolvedmenu.getScaledInstance(lblBusolvedmenu.getWidth(), lblBusolvedmenu.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledBusolvedmenu = new ImageIcon(imgBusolvedmenu2);
		lblBusolvedmenu.setIcon(scaledBusolvedmenu);
		
        /*================== Restaurant A ==================*/
        JLabel lblPizza, lblIcecream, lblQty, lblPrice, lblPrice2, lblQty2;
        lblPizza = new JLabel("Pizza");
        lblPizza.setBounds(145, 100, 50, 30);
        lblIcecream = new JLabel("Ice Cream");
        lblIcecream.setBounds(450, 100, 100, 30);
        lblQty = new JLabel("Quantity");
        lblQty.setBounds(240, 100, 100, 30);
        lblPrice = new JLabel("Price");
        lblPrice.setBounds(50, 100, 100, 30);
        lblQty2 = new JLabel("Quantity");
        lblQty2.setBounds(550, 100, 100, 30);
        lblPrice2 = new JLabel("Price");
        lblPrice2.setBounds(355, 100, 100, 30);

        JLabel lblHawaiian, lblHam, lblCheese, lblMeat, lblPep;
        lblHawaiian = new JLabel ("P 100.50");
        lblHawaiian.setBounds(40, 150, 130, 30);
        lblHam = new JLabel ("P 150.00");
        lblHam.setBounds(40, 190, 130, 30);
        lblCheese = new JLabel("P 110.50");
        lblCheese.setBounds(40, 230, 130, 30);
        lblMeat = new JLabel("P 200.00");
        lblMeat.setBounds(40, 270, 130, 30);
        lblPep = new JLabel("P 160.25");
        lblPep.setBounds(40, 310, 130, 30);

        JLabel lblVanilla, lblChocolate, lblStraw, lblMango,lblUbe;
        lblVanilla = new JLabel("P 15.00");
        lblVanilla.setBounds(350, 150, 130, 30);
        lblChocolate = new JLabel("P 15.00");
        lblChocolate.setBounds(350, 190, 130, 30);
        lblStraw = new JLabel("P 25.00");
        lblStraw.setBounds(350, 230, 130, 30);
        lblMango = new JLabel("P 20.00");
        lblMango.setBounds(350, 270, 130, 30);
        lblUbe = new JLabel("P 30.00");
        lblUbe.setBounds(350, 310, 130, 30);

        JCheckBox cbHawaiian, cbHam, cbCheese, cbMeat, cbPep;
        cbHawaiian = new JCheckBox ("Hawaiian");
        cbHawaiian.setBounds(100, 150, 130, 30);
        cbHam = new JCheckBox ("Ham and Cheese");
        cbHam.setBounds(100, 190, 130, 30);
        cbCheese = new JCheckBox("Cheese");
        cbCheese.setBounds(100, 230, 130, 30);
        cbMeat = new JCheckBox("Meat Lover");
        cbMeat.setBounds(100, 270, 130, 30);
        cbPep = new JCheckBox("Pepperoni");
        cbPep.setBounds(100, 310, 130, 30);

        JCheckBox cbVanilla, cbChocolate, cbStraw, cbMango, cbUbe;
        cbVanilla = new JCheckBox("Vanilla");
        cbVanilla.setBounds(410, 150, 130, 30);
        cbChocolate = new JCheckBox("Chocolate");
        cbChocolate.setBounds(410, 190, 130, 30);
        cbStraw = new JCheckBox("Strawbery");
        cbStraw.setBounds(410, 230, 130, 30);
        cbMango = new JCheckBox("Mango");
        cbMango.setBounds(410, 270, 130, 30);
        cbUbe = new JCheckBox("Ube");
        cbUbe.setBounds(410, 310, 130, 30);

        JTextField txtHawaiian, txtHam, txtCheese, txtMeat, txtPep;
        txtHawaiian = new JTextField(20);
        txtHawaiian.setBounds(240, 150, 50, 30);
        txtHam = new JTextField(20);
        txtHam.setBounds(240, 190, 50, 30);
        txtCheese = new JTextField(20);
        txtCheese.setBounds(240, 230, 50, 30);
        txtMeat = new JTextField(20);
        txtMeat.setBounds(240, 270, 50, 30);
        txtPep = new JTextField(20);
        txtPep.setBounds(240, 310, 50, 30);

        JTextField txtVanilla, txtChocolate, txtStraw, txtMango, txtUbe;
        txtVanilla = new JTextField(20);
        txtVanilla.setBounds(550, 150, 50, 30);
        txtChocolate = new JTextField(20);
        txtChocolate.setBounds(550, 190, 50, 30);
        txtStraw = new JTextField(20);
        txtStraw.setBounds(550, 230, 50, 30);
        txtMango = new JTextField(20);
        txtMango.setBounds(550, 270, 50, 30);
        txtUbe = new JTextField(20);
        txtUbe.setBounds(550, 310, 50, 30);

        JLabel lblCostp, lblCosti, lblItotal, lblDelCha, lblTotal;
        lblCostp = new JLabel("Pizza");
        lblCostp.setBounds(30, 400, 50, 30);
        lblCosti = new JLabel("Ice Cream");
        lblCosti.setBounds(30, 450, 100, 30);
        lblItotal = new JLabel("Initial Total");
        lblItotal.setBounds(30, 500, 100, 30);
        lblDelCha = new JLabel("Delivery Charge");
        lblDelCha.setBounds(260, 400, 100, 30);
        lblTotal = new JLabel("Total Amount");
        lblTotal.setBounds(260, 450, 100, 30);

        JTextField txtCostp, txtCosti, txtItotal, txtDelCha, txtTotal;
        txtCostp = new JTextField(10);
        txtCostp.setBounds(120, 400, 100, 30);
        txtCosti = new JTextField(10);
        txtCosti.setBounds(120, 450, 100, 30);
        txtItotal = new JTextField(10);
        txtItotal.setBounds(120, 500, 100, 30);
        txtDelCha = new JTextField(10);
        txtDelCha.setBounds(370, 400, 100, 30);
        txtTotal = new JTextField(10);
        txtTotal.setBounds(370, 450, 100, 30);

        JTextArea taReceipt = new JTextArea();
        taReceipt.setBounds(620, 40, 350, 600);

        /*================== Restaurant B ==================*/

        JLabel lblMeal, lblDrinks;
        lblMeal = new JLabel("Rice Meals");
        lblMeal.setBounds(130, 100, 100, 30);
        lblDrinks = new JLabel("Drinks");
        lblDrinks.setBounds(450, 100, 100, 30);

        JLabel lblCostm, lblCostd;
        lblCostm = new JLabel("Rice Meals");
        lblCostm.setBounds(30, 400, 100, 30);
        lblCostd = new JLabel("Drinks");
        lblCostd.setBounds(30, 450, 100, 30);

        JTextField txtCostm, txtCostd, txtItotal2, txtDelCha2, txtTotal2;
        txtCostm = new JTextField(10);
        txtCostm.setBounds(120, 400, 100, 30);
        txtCostd = new JTextField(10);
        txtCostd.setBounds(120, 450, 100, 30);
        txtItotal2 = new JTextField(10);
        txtItotal2.setBounds(120, 500, 100, 30);
        txtDelCha2 = new JTextField(10);
        txtDelCha2.setBounds(370, 400, 100, 30);
        txtTotal2 = new JTextField(10);
        txtTotal2.setBounds(370, 450, 100, 30);

        JCheckBox cbTapsi, cbLongsi, cbHotsi, cbCornsi, cbTosi;
        cbTapsi = new JCheckBox ("Tapsilog");
        cbTapsi.setBounds(100, 150, 130, 30);
        cbLongsi = new JCheckBox ("Longsilog");
        cbLongsi.setBounds(100, 190, 130, 30);
        cbHotsi = new JCheckBox("Hotsilog");
        cbHotsi.setBounds(100, 230, 130, 30);
        cbCornsi = new JCheckBox("Cornsilog");
        cbCornsi.setBounds(100, 270, 130, 30);
        cbTosi = new JCheckBox("Tosilog");
        cbTosi.setBounds(100, 310, 130, 30);

        JCheckBox cbTea, cbCoke, cbSprite, cbJuice, cbLemon;
        cbTea = new JCheckBox("Iced Tea");
        cbTea.setBounds(410, 150, 130, 30);
        cbCoke = new JCheckBox("Coke in Can");
        cbCoke.setBounds(410, 190, 130, 30);
        cbSprite = new JCheckBox("Sprite in Can");
        cbSprite.setBounds(410, 230, 130, 30);
        cbJuice = new JCheckBox("Orange Juice");
        cbJuice.setBounds(410, 270, 130, 30);
        cbLemon = new JCheckBox("Lemonade");
        cbLemon.setBounds(410, 310, 130, 30);

        JTextField txtTapsi, txtLongsi, txtHotsi, txtCornsi, txtTosi;
        txtTapsi = new JTextField(20);
        txtTapsi.setBounds(240, 150, 50, 30);
        txtLongsi = new JTextField(20);
        txtLongsi.setBounds(240, 190, 50, 30);
        txtHotsi = new JTextField(20);
        txtHotsi.setBounds(240, 230, 50, 30);
        txtCornsi = new JTextField(20);
        txtCornsi.setBounds(240, 270, 50, 30);
        txtTosi = new JTextField(20);
        txtTosi.setBounds(240, 310, 50, 30);

        JTextField txtTea, txtCoke, txtSprite, txtJuice, txtLemon;
        txtTea = new JTextField(20);
        txtTea.setBounds(550, 150, 50, 30);
        txtCoke = new JTextField(20);
        txtCoke.setBounds(550, 190, 50, 30);
        txtSprite = new JTextField(20);
        txtSprite.setBounds(550, 230, 50, 30);
        txtJuice = new JTextField(20);
        txtJuice.setBounds(550, 270, 50, 30);
        txtLemon = new JTextField(20);
        txtLemon.setBounds(550, 310, 50, 30);

        JLabel lblTapsi, lblLongsi, lblHotsi, lblCornsi, lblTosi;
        lblTapsi = new JLabel ("P 70.00");
        lblTapsi.setBounds(40, 150, 130, 30);
        lblLongsi = new JLabel ("P 60.00");
        lblLongsi.setBounds(40, 190, 130, 30);
        lblHotsi = new JLabel("P 55.00");
        lblHotsi.setBounds(40, 230, 130, 30);
        lblCornsi = new JLabel("P 55.00");
        lblCornsi.setBounds(40, 270, 130, 30);
        lblTosi = new JLabel("P 65.00");
        lblTosi.setBounds(40, 310, 130, 30);

        JLabel lblTea, lblCoke, lblSprite, lblJuice,lblLemon;
        lblTea = new JLabel("P 40.00");
        lblTea.setBounds(350, 150, 130, 30);
        lblCoke = new JLabel("P 30.00");
        lblCoke.setBounds(350, 190, 130, 30);
        lblSprite = new JLabel("P 30.00");
        lblSprite.setBounds(350, 230, 130, 30);
        lblJuice = new JLabel("P 45.00");
        lblJuice.setBounds(350, 270, 130, 30);
        lblLemon = new JLabel("P 50.00");
        lblLemon.setBounds(350, 310, 130, 30);

        JTextArea taReceipt2 = new JTextArea();
        taReceipt2.setBounds(620, 40, 350, 600);

        /*================== Initial Total, Reset and Checkout ==================*/
        JButton btnItotal, btnReset, btnCheck;
        btnItotal = new JButton ("Total");
        btnItotal.setBounds(120, 600, 100, 30);
        btnReset = new JButton("Reset");
        btnReset.setBounds(230, 600, 100, 30);
        btnCheck = new JButton("Check Out");
        btnCheck.setBounds(340, 600, 100, 30);

        /*========================== Adding to frmWindow ==========================*/
        frmWindow.setLayout(null);
        frmWindow.setSize(1000,700);
        frmWindow.setVisible(true);
        frmWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmWindow.setLocationRelativeTo(null);

        frmWindow.add(panelMenu);
        frmWindow.add(lblFos);
        panelMenu.add(btnUser);
        panelMenu.add(btnResto);
        panelMenu.add(btnOrder);
        frmWindow.add(panelMenu2);
        
        frmWindow.add(lblSlicesmenu);      
        frmWindow.add(lblBusolvedmenu);        
        frmWindow.add(lblSlices);        
        frmWindow.add(lblBusolved);
        frmWindow.add(lblSlicesdes);
        frmWindow.add(lblBusolveddes);
        
        
        lblSlicesmenu.setVisible(false);
        lblBusolvedmenu.setVisible(false);
        lblSlices.setVisible(false);
        lblBusolved.setVisible(false);        
        lblSlicesdes.setVisible(false);
        lblBusolveddes.setVisible(false);
        lblFos.setVisible(true);

//=============== Restaurant A ===============
        frmWindow.add(lblPizza);
        frmWindow.add(lblIcecream);
        frmWindow.add(lblQty);
        frmWindow.add(lblPrice);
        frmWindow.add(lblQty2);
        frmWindow.add(lblPrice2);
        frmWindow.add(lblCostp);
        frmWindow.add(lblCosti);
        frmWindow.add(lblItotal);
        frmWindow.add(lblDelCha);
        frmWindow.add(lblHawaiian);
        frmWindow.add(lblHam);
        frmWindow.add(lblCheese);
        frmWindow.add(lblMeat);
        frmWindow.add(lblPep);
        frmWindow.add(lblVanilla);
        frmWindow.add(lblChocolate);
        frmWindow.add(lblMango);
        frmWindow.add(lblStraw);
        frmWindow.add(lblUbe);
        frmWindow.add(lblTotal);

        frmWindow.add(taReceipt);

        frmWindow.add(cboResto);
        frmWindow.add(lblResto);

        frmWindow.add(cbHam);
        frmWindow.add(cbHawaiian);
        frmWindow.add(cbCheese);
        frmWindow.add(cbMeat);
        frmWindow.add(cbPep);
        frmWindow.add(cbVanilla);
        frmWindow.add(cbChocolate);
        frmWindow.add(cbStraw);
        frmWindow.add(cbMango);
        frmWindow.add(cbUbe);

        frmWindow.add(txtHam);
        frmWindow.add(txtHawaiian);
        frmWindow.add(txtCheese);
        frmWindow.add(txtMeat);
        frmWindow.add(txtPep);
        frmWindow.add(txtVanilla);
        frmWindow.add(txtChocolate);
        frmWindow.add(txtStraw);
        frmWindow.add(txtMango);
        frmWindow.add(txtUbe);
        frmWindow.add(txtCostp);
        frmWindow.add(txtCosti);
        frmWindow.add(txtItotal);
        frmWindow.add(txtDelCha);
        frmWindow.add(txtTotal);

        cbHawaiian.setVisible(false);
        cbHam.setVisible(false);
        cbCheese.setVisible(false);
        cbMeat.setVisible(false);
        cbPep.setVisible(false);
        cbVanilla.setVisible(false);
        cbChocolate.setVisible(false);
        cbStraw.setVisible(false);
        cbMango.setVisible(false);
        cbUbe.setVisible(false);
        btnItotal.setVisible(false);
        btnReset.setVisible(false);
        btnCheck.setVisible(false);
        txtCostp.setVisible(false);
        txtCosti.setVisible(false);
        txtDelCha.setVisible(false);
        txtTotal.setVisible(false);
        txtItotal.setVisible(false);
        txtHawaiian.setVisible(false);
        txtHam.setVisible(false);
        txtCheese.setVisible(false);
        txtMeat.setVisible(false);
        txtPep.setVisible(false);
        txtVanilla.setVisible(false);
        txtChocolate.setVisible(false);
        txtStraw.setVisible(false);
        txtMango.setVisible(false);
        txtUbe.setVisible(false);
        taReceipt.setVisible(false);

//=============== Restaurant B ===============
        frmWindow.add(cbTapsi);
        frmWindow.add(cbLongsi);
        frmWindow.add(cbHotsi);
        frmWindow.add(cbCornsi);
        frmWindow.add(cbTosi);
        frmWindow.add(cbTea);
        frmWindow.add(cbCoke);
        frmWindow.add(cbSprite);
        frmWindow.add(cbJuice);
        frmWindow.add(cbLemon);

        frmWindow.add(txtTapsi);
        frmWindow.add(txtLongsi);
        frmWindow.add(txtHotsi);
        frmWindow.add(txtCornsi);
        frmWindow.add(txtTosi);
        frmWindow.add(txtTea);
        frmWindow.add(txtCoke);
        frmWindow.add(txtSprite);
        frmWindow.add(txtJuice);
        frmWindow.add(txtLemon);
        frmWindow.add(txtCostm);
        frmWindow.add(txtCostd);
        frmWindow.add(txtItotal2);
        frmWindow.add(txtDelCha2);
        frmWindow.add(txtTotal2);

        frmWindow.add(lblTapsi);
        frmWindow.add(lblLongsi);
        frmWindow.add(lblHotsi);
        frmWindow.add(lblCornsi);
        frmWindow.add(lblTosi);
        frmWindow.add(lblTea);
        frmWindow.add(lblCoke);
        frmWindow.add(lblSprite);
        frmWindow.add(lblLemon);
        frmWindow.add(lblJuice);
        frmWindow.add(lblMeal);
        frmWindow.add(lblDrinks);
        frmWindow.add(lblCostm);
        frmWindow.add(lblCostd);

        frmWindow.add(taReceipt2);

        cbTapsi.setVisible(false);
        cbLongsi.setVisible(false);
        cbHotsi.setVisible(false);
        cbCornsi.setVisible(false);
        cbTosi.setVisible(false);
        cbTea.setVisible(false);
        cbCoke.setVisible(false);
        cbSprite.setVisible(false);
        cbJuice.setVisible(false);
        cbLemon.setVisible(false);
        txtTapsi.setVisible(false);
        txtLongsi.setVisible(false);
        txtHotsi.setVisible(false);
        txtCornsi.setVisible(false);
        txtTosi.setVisible(false);
        txtTea.setVisible(false);
        txtCoke.setVisible(false);
        txtSprite.setVisible(false);
        txtJuice.setVisible(false);
        txtLemon.setVisible(false);
        txtCostm.setVisible(false);
        txtCostd.setVisible(false);
        txtItotal2.setVisible(false);
        txtDelCha2.setVisible(false);
        txtTotal2.setVisible(false);
        taReceipt2.setVisible(false);
        
//=============== Panel User ===============
        frmWindow.add(taTerms);
        frmWindow.add(sp);
        frmWindow.add(lblName);
        frmWindow.add(lblAddress);
        frmWindow.add(lblConInfo);
        frmWindow.add(lblImage);
        frmWindow.add(txtName);
        frmWindow.add(txtConInfo);
        frmWindow.add(taAddress);
        frmWindow.add(btnEdit);
        frmWindow.add(btnSend);
        frmWindow.add(cbTerms);

        taTerms.setVisible(false);
        sp.setVisible(false);
        lblName.setVisible(false);
        lblAddress.setVisible(false);
        lblConInfo.setVisible(false);
        lblImage.setVisible(false);
        txtName.setVisible(false);
        txtConInfo.setVisible(false);
        taAddress.setVisible(false);
        btnEdit.setVisible(false);
        btnSend.setVisible(false);
        cbTerms.setVisible(false);
        panelUser.setVisible(false);

        frmWindow.add(btnItotal);
        frmWindow.add(btnReset);
        frmWindow.add(btnCheck);

        frmWindow.add(panelA);
        frmWindow.add(panelB);
        frmWindow.add(panelUser);

        /*=========================== Button User ===========================*/
        btnUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent objAE) {
                panelUser.setBounds(0, 0, 1000, 700);
                panelUser.setBackground(Color.LIGHT_GRAY);

                frmWindow.add(panelUser);
                panelUser.setVisible(true);
                panelMenu2.setVisible(false);
                panelMenu3.setVisible(false);
                panelResto.setVisible(false);
                cboResto.setVisible(false);
                lblResto.setVisible(false);
                txtHawaiian.setVisible(false);
                txtHam.setVisible(false);
                txtCheese.setVisible(false);
                txtMeat.setVisible(false);
                txtPep.setVisible(false);
                txtVanilla.setVisible(false);
                txtChocolate.setVisible(false);
                txtStraw.setVisible(false);
                txtMango.setVisible(false);
                txtUbe.setVisible(false);
                cbMeat.setVisible(false);
                cbPep.setVisible(false);
                cbVanilla.setVisible(false);
                cbChocolate.setVisible(false);
                cbStraw.setVisible(false);
                cbMango.setVisible(false);
                cbUbe.setVisible(false);
                txtDelCha.setVisible(false);
                txtTotal.setVisible(false);
                lblPizza.setVisible(false);
                lblIcecream.setVisible(false);
                lblQty.setVisible(false);
                lblPrice.setVisible(false);
                lblQty2.setVisible(false);
                lblPrice2.setVisible(false);
                lblHawaiian.setVisible(false);
                lblHam.setVisible(false);
                lblCheese.setVisible(false);
                lblMeat.setVisible(false);
                lblPep.setVisible(false);
                lblVanilla.setVisible(false);
                lblChocolate.setVisible(false);
                lblMango.setVisible(false);
                lblStraw.setVisible(false);
                lblUbe.setVisible(false);
                cbHawaiian.setVisible(false);
                cbHam.setVisible(false);
                cbCheese.setVisible(false);
                lblCostp.setVisible(false);
                lblCosti.setVisible(false);
                lblItotal.setVisible(false);
                btnItotal.setVisible(false);
                btnReset.setVisible(false);
                btnCheck.setVisible(false);
                taReceipt.setVisible(false);
                lblDelCha.setVisible(false);
                lblTotal.setVisible(false);
                cbTapsi.setVisible(false);
                cbLongsi.setVisible(false);
                cbHotsi.setVisible(false);
                cbCornsi.setVisible(false);
                cbTosi.setVisible(false);
                cbTea.setVisible(false);
                cbCoke.setVisible(false);
                cbSprite.setVisible(false);
                cbJuice.setVisible(false);
                cbLemon.setVisible(false);
                txtTapsi.setVisible(false);
                txtLongsi.setVisible(false);
                txtHotsi.setVisible(false);
                txtCornsi.setVisible(false);
                txtTosi.setVisible(false);
                txtTea.setVisible(false);
                txtCoke.setVisible(false);
                txtSprite.setVisible(false);
                txtJuice.setVisible(false);
                txtItotal.setVisible(false);
                txtLemon.setVisible(false);
                lblTapsi.setVisible(false);
                lblLongsi.setVisible(false);
                lblHotsi.setVisible(false);
                lblCornsi.setVisible(false);
                lblTosi.setVisible(false);
                lblTea.setVisible(false);
                lblCoke.setVisible(false);
                lblSprite.setVisible(false);
                lblJuice.setVisible(false);
                lblLemon.setVisible(false);
                lblMeal.setVisible(false);
                lblDrinks.setVisible(false);
                txtCostm.setVisible(false);
                txtCostd.setVisible(false);
                txtItotal2.setVisible(false);
                txtDelCha2.setVisible(false);
                txtTotal2.setVisible(false);
                lblCostm.setVisible(false);
                lblCostd.setVisible(false);
                taReceipt2.setVisible(false);
                txtCostp.setVisible(false);
                txtCosti.setVisible(false);
                lblSlicesmenu.setVisible(false);
                lblBusolvedmenu.setVisible(false);
                lblSlices.setVisible(false);
                lblBusolved.setVisible(false);
                lblSlicesdes.setVisible(false);
                lblBusolveddes.setVisible(false);
                lblFos.setVisible(false);

                taTerms.setVisible(true);
                sp.setVisible(true);
                lblName.setVisible(true);
                lblAddress.setVisible(true);
                lblConInfo.setVisible(true);
                lblImage.setVisible(true);
                txtName.setVisible(true);
                txtConInfo.setVisible(true);
                taAddress.setVisible(true);
                btnEdit.setVisible(true);
                btnSend.setVisible(true);
                cbTerms.setVisible(true);
                panelUser.setVisible(true);
                
                taTerms.addKeyListener(new KeyListener() {
                    public void keyTyped(KeyEvent objKE) {
                        char charNum = objKE.getKeyChar();
                        if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                (charNum == KeyEvent.VK_BACK_SPACE) ||
                                (charNum == KeyEvent.VK_DELETE)) {
                            objKE.consume();
                        }
                    }
                    public void keyPressed(KeyEvent e) {}
                    public void keyReleased(KeyEvent e) {}
                });
                
                txtConInfo.addKeyListener(new KeyListener() {
                    public void keyTyped(KeyEvent objKE) {
                        char charNum = objKE.getKeyChar();
                        if(!(Character.isDigit(charNum)) || 
                                (charNum == KeyEvent.VK_BACK_SPACE) ||
                                (charNum == KeyEvent.VK_DELETE)) {
                            objKE.consume();
                        }
                    }
                    public void keyPressed(KeyEvent e) {}
                    public void keyReleased(KeyEvent e) {}
                });
                
                /*=========================== Button UserProfile Available ===========================*/
                //Save
                //this button will performed saving info using setenabled and messagebox
                btnSend.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent objAE) {
                        String text1 = txtName.getText();
                        String text2 = txtConInfo.getText();
                        String text3 = taAddress.getText();

                        //Warnings to the user
                        if(text1.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please fill-up your Name", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                        if(text2.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please fill-up your contact info", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                        if(text3.equals("")){
                            JOptionPane.showMessageDialog(null, "Please fill-up your Address","Alert",JOptionPane.WARNING_MESSAGE);

                            //Question Message to the User
                        } else {
                            int a = JOptionPane.showConfirmDialog(null, "Do you want to proceed in our Menu?", "Checkout Information",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if(a == JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(null, "Proceed to Order");

                                btnSend.setEnabled(false);
                                txtName.setEnabled(false);
                                txtConInfo.setEnabled(false);
                                taAddress.setEnabled(false);
                                cbTerms.setEnabled(false);
                                btnOrder.setEnabled(true);
                                taTerms.setEnabled(false);
                            }
                            else if(a == JOptionPane.NO_OPTION) {
                                int b = JOptionPane.showConfirmDialog(null, "Do you want to reset your previous data?", "Checkout Information",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                //reset functon
                                if(b == JOptionPane.YES_OPTION){
                                    JOptionPane.showMessageDialog(null, "Your input data will be reset");
                                    cbTerms.setSelected(false);
                                    txtName.setText("");
                                    txtConInfo.setText("");
                                    taAddress.setText("");}
                                    btnSend.setEnabled(false);
                                // no reset function
                                if(b == JOptionPane.NO_OPTION){
                                    txtName.setText("" + text1);
                                    txtConInfo.setText("" + text2);
                                    taAddress.setText("" + text3);
                                    cbTerms.setSelected(false);
                                }
                            }}
                    }});

                //Edit
                btnEdit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent objAE) {
                        cbTerms.setSelected(false);
                        txtName.setEnabled(true);
                        txtConInfo.setEnabled(true);
                        taAddress.setEnabled(true);
                        cbTerms.setEnabled(true);
                        btnOrder.setEnabled(false);
                        taTerms.setEnabled(true);
                    }
                });
                //terms and conditions
                cbTerms.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent objME) {
                        if(cbTerms.isSelected()) {
                            btnSend.setEnabled(true);
                        }else{
                            btnSend.setEnabled(false);
                        }
                    }
                    public void mousePressed(MouseEvent objME) {}
                    public void mouseReleased(MouseEvent objME) {}
                    public void mouseEntered(MouseEvent objME) {}
                    public void mouseExited(MouseEvent objME) {}
                });

            }
        });

        /*=========================== Button Restaurant Available ===========================*/
        btnResto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent objAE) {
                panelResto.setBounds(0, 0, 1000, 700);
                panelResto.setBackground(Color.LIGHT_GRAY);

                frmWindow.add(panelResto);
                panelResto.setVisible(true);
                panelUser.setVisible(false);
                panelMenu2.setVisible(false);
                panelMenu3.setVisible(false);
                cboResto.setVisible(false);
                lblResto.setVisible(false);
                txtHawaiian.setVisible(false);
                txtHam.setVisible(false);
                txtCheese.setVisible(false);
                txtMeat.setVisible(false);
                txtPep.setVisible(false);
                txtVanilla.setVisible(false);
                txtChocolate.setVisible(false);
                txtStraw.setVisible(false);
                txtMango.setVisible(false);
                txtUbe.setVisible(false);
                cbMeat.setVisible(false);
                cbPep.setVisible(false);
                cbVanilla.setVisible(false);
                cbChocolate.setVisible(false);
                cbStraw.setVisible(false);
                cbMango.setVisible(false);
                cbUbe.setVisible(false);
                txtDelCha.setVisible(false);
                txtTotal.setVisible(false);
                lblPizza.setVisible(false);
                lblIcecream.setVisible(false);
                lblQty.setVisible(false);
                lblPrice.setVisible(false);
                lblQty2.setVisible(false);
                lblPrice2.setVisible(false);
                lblHawaiian.setVisible(false);
                lblHam.setVisible(false);
                lblCheese.setVisible(false);
                lblMeat.setVisible(false);
                lblPep.setVisible(false);
                lblVanilla.setVisible(false);
                lblChocolate.setVisible(false);
                lblMango.setVisible(false);
                lblStraw.setVisible(false);
                lblUbe.setVisible(false);
                cbHawaiian.setVisible(false);
                cbHam.setVisible(false);
                cbCheese.setVisible(false);
                lblCostp.setVisible(false);
                lblCosti.setVisible(false);
                lblItotal.setVisible(false);
                btnItotal.setVisible(false);
                btnReset.setVisible(false);
                btnCheck.setVisible(false);
                taReceipt.setVisible(false);
                lblDelCha.setVisible(false);
                lblTotal.setVisible(false);
                cbTapsi.setVisible(false);
                cbLongsi.setVisible(false);
                cbHotsi.setVisible(false);
                cbCornsi.setVisible(false);
                cbTosi.setVisible(false);
                cbTea.setVisible(false);
                cbCoke.setVisible(false);
                cbSprite.setVisible(false);
                cbJuice.setVisible(false);
                cbLemon.setVisible(false);
                txtTapsi.setVisible(false);
                txtLongsi.setVisible(false);
                txtHotsi.setVisible(false);
                txtCornsi.setVisible(false);
                txtTosi.setVisible(false);
                txtTea.setVisible(false);
                txtCoke.setVisible(false);
                txtSprite.setVisible(false);
                txtJuice.setVisible(false);
                txtLemon.setVisible(false);
                lblTapsi.setVisible(false);
                lblLongsi.setVisible(false);
                lblHotsi.setVisible(false);
                lblCornsi.setVisible(false);
                lblTosi.setVisible(false);
                lblTea.setVisible(false);
                lblCoke.setVisible(false);
                lblSprite.setVisible(false);
                lblJuice.setVisible(false);
                lblLemon.setVisible(false);
                txtCostm.setVisible(false);
                txtCostd.setVisible(false);
                txtItotal.setVisible(false);
                txtItotal2.setVisible(false);
                txtDelCha2.setVisible(false);
                txtTotal2.setVisible(false);
                lblCostm.setVisible(false);
                lblCostd.setVisible(false);
                taReceipt2.setVisible(false);
                lblMeal.setVisible(false);
                lblDrinks.setVisible(false);
                txtCostp.setVisible(false);
                txtCosti.setVisible(false);
                lblSlicesmenu.setVisible(false);
                lblBusolvedmenu.setVisible(false);   
                lblFos.setVisible(false);
                
                taTerms.setVisible(false);
                sp.setVisible(false);
                lblName.setVisible(false);
                lblAddress.setVisible(false);
                lblConInfo.setVisible(false);
                lblImage.setVisible(false);
                txtName.setVisible(false);
                txtConInfo.setVisible(false);
                taAddress.setVisible(false);
                btnEdit.setVisible(false);
                btnSend.setVisible(false);
                cbTerms.setVisible(false);
                panelUser.setVisible(false);
                
                lblSlices.setVisible(true);
                lblBusolved.setVisible(true);
                lblSlicesdes.setVisible(true);
                lblBusolveddes.setVisible(true);
            }
        });

        /*=========================== Button Order Here ===========================*/
        btnOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent objAE) {
                panelMenu3.setBounds(0, 0, 1000, 700);
                panelMenu3.setBackground(Color.LIGHT_GRAY);

                cboResto.setBounds(150, 50, 150, 30);
                lblResto.setBounds(5, 50, 300, 30);

                frmWindow.add(panelMenu3);
                panelMenu2.setVisible(false);
                panelUser.setVisible(false);
                panelResto.setVisible(false);
                panelMenu3.setVisible(true);
                cboResto.setVisible(true);
                lblResto.setVisible(true);
                lblPizza.setVisible(false);
                lblIcecream.setVisible(false);
                lblQty.setVisible(false);
                lblPrice.setVisible(false);
                lblQty2.setVisible(false);
                lblPrice2.setVisible(false);
                lblHawaiian.setVisible(false);
                lblHam.setVisible(false);
                lblCheese.setVisible(false);
                lblMeat.setVisible(false);
                lblPep.setVisible(false);
                lblVanilla.setVisible(false);
                lblChocolate.setVisible(false);
                lblMango.setVisible(false);
                lblStraw.setVisible(false);
                lblUbe.setVisible(false);
                cbHawaiian.setVisible(false);
                cbHam.setVisible(false);
                cbCheese.setVisible(false);
                cbVanilla.setVisible(false);
                cbChocolate.setVisible(false);
                cbStraw.setVisible(false);
                cbMango.setVisible(false);
                cbUbe.setVisible(false);
                txtHawaiian.setVisible(false);
                txtHam.setVisible(false);
                txtCheese.setVisible(false);
                txtMeat.setVisible(false);
                txtPep.setVisible(false);
                txtVanilla.setVisible(false);
                txtChocolate.setVisible(false);
                txtStraw.setVisible(false);
                txtMango.setVisible(false);
                txtUbe.setVisible(false);
                cbMeat.setVisible(false);
                cbPep.setVisible(false);
                txtDelCha.setVisible(false);
                txtTotal.setVisible(false);
                lblCostp.setVisible(false);
                lblCosti.setVisible(false);
                lblItotal.setVisible(false);
                btnItotal.setVisible(false);
                btnReset.setVisible(false);
                btnCheck.setVisible(false);
                taReceipt.setVisible(false);
                lblDelCha.setVisible(false);
                lblTotal.setVisible(false);
                cbTapsi.setVisible(false);
                cbLongsi.setVisible(false);
                cbHotsi.setVisible(false);
                cbCornsi.setVisible(false);
                cbTosi.setVisible(false);
                cbTea.setVisible(false);
                cbCoke.setVisible(false);
                cbSprite.setVisible(false);
                cbJuice.setVisible(false);
                cbLemon.setVisible(false);
                txtTapsi.setVisible(false);
                txtLongsi.setVisible(false);
                txtHotsi.setVisible(false);
                txtCornsi.setVisible(false);
                txtTosi.setVisible(false);
                txtTea.setVisible(false);
                txtCoke.setVisible(false);
                txtSprite.setVisible(false);
                txtJuice.setVisible(false);
                txtLemon.setVisible(false);
                lblTapsi.setVisible(false);
                lblLongsi.setVisible(false);
                lblHotsi.setVisible(false);
                lblCornsi.setVisible(false);
                lblTosi.setVisible(false);
                lblTea.setVisible(false);
                lblCoke.setVisible(false);
                lblSprite.setVisible(false);
                lblJuice.setVisible(false);
                lblLemon.setVisible(false);
                lblMeal.setVisible(false);
                lblDrinks.setVisible(false);
                txtCostm.setVisible(false);
                txtCostd.setVisible(false);
                txtItotal2.setVisible(false);
                txtDelCha2.setVisible(false);
                txtTotal2.setVisible(false);
                lblCostm.setVisible(false);
                lblCostd.setVisible(false);
                taReceipt2.setVisible(false);
                lblSlices.setVisible(false);
                lblBusolved.setVisible(false);
                lblSlicesdes.setVisible(false);
                lblBusolveddes.setVisible(false);
                lblFos.setVisible(false);

                taTerms.setVisible(false);
                sp.setVisible(false);
                lblName.setVisible(false);
                lblAddress.setVisible(false);
                lblConInfo.setVisible(false);
                lblImage.setVisible(false);
                txtName.setVisible(false);
                txtConInfo.setVisible(false);
                taAddress.setVisible(false);
                btnEdit.setVisible(false);
                btnSend.setVisible(false);
                cbTerms.setVisible(false);
                panelUser.setVisible(false);
                
                lblSlicesmenu.setVisible(true);
                lblBusolvedmenu.setVisible(true);
            }
        });

        /*=========================== Combo box to select restaurant of choice ===========================*/
        cboResto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent objAE) {
                int intIndex = cboResto.getSelectedIndex();

                /*=========================== If Restaurant A ===========================*/
                if(intIndex == 1) {

                    txtCostp.setText("0.00");
                    txtCosti.setText("0.00");
                    txtItotal.setText("0.00");
                    txtDelCha.setText("0.00");
                    txtTotal.setText("0.00");
                    txtHawaiian.setText("0");
                    txtHam.setText("0");
                    txtCheese.setText("0");
                    txtMeat.setText("0");
                    txtPep.setText("0");
                    txtVanilla.setText("0");
                    txtChocolate.setText("0");
                    txtStraw.setText("0");
                    txtMango.setText("0");
                    txtUbe.setText("0");
                    taReceipt.setText(null);

                    cbHam.setSelected(false);
                    cbCheese.setSelected(false);
                    cbHawaiian.setSelected(false);
                    cbMeat.setSelected(false);
                    cbPep.setSelected(false);
                    cbVanilla.setSelected(false);
                    cbChocolate.setSelected(false);
                    cbStraw.setSelected(false);
                    cbMango.setSelected(false);
                    cbUbe.setSelected(false);

                    txtHawaiian.setEnabled(false);
                    txtHam.setEnabled(false);
                    txtCheese.setEnabled(false);
                    txtMeat.setEnabled(false);
                    txtPep.setEnabled(false);
                    txtVanilla.setEnabled(false);
                    txtChocolate.setEnabled(false);
                    txtStraw.setEnabled(false);
                    txtMango.setEnabled(false);
                    txtUbe.setEnabled(false);

                    panelA.setBounds(0, 0, 1000, 700);
                    panelA.setBackground(Color.LIGHT_GRAY);
                    panelMenu3.setVisible(true);
                    cboResto.setVisible(true);
                    lblResto.setVisible(true);
                    panelA.setVisible(true);
                    lblPizza.setVisible(true);
                    lblIcecream.setVisible(true);
                    lblQty.setVisible(true);
                    lblPrice.setVisible(true);
                    lblQty2.setVisible(true);
                    lblPrice2.setVisible(true);
                    lblHawaiian.setVisible(true);
                    lblHam.setVisible(true);
                    lblCheese.setVisible(true);
                    lblMeat.setVisible(true);
                    lblPep.setVisible(true);
                    lblVanilla.setVisible(true);
                    lblChocolate.setVisible(true);
                    lblMango.setVisible(true);
                    lblStraw.setVisible(true);
                    lblUbe.setVisible(true);
                    cbHawaiian.setVisible(true);
                    cbHam.setVisible(true);
                    cbCheese.setVisible(true);
                    cbVanilla.setVisible(true);
                    cbChocolate.setVisible(true);
                    txtHawaiian.setVisible(true);
                    txtHam.setVisible(true);
                    txtCheese.setVisible(true);
                    txtMeat.setVisible(true);
                    txtPep.setVisible(true);
                    txtVanilla.setVisible(true);
                    txtChocolate.setVisible(true);
                    txtMango.setVisible(true);
                    txtUbe.setVisible(true);
                    txtStraw.setVisible(true);
                    cbMeat.setVisible(true);
                    cbPep.setVisible(true);
                    cbStraw.setVisible(true);
                    cbMango.setVisible(true);
                    cbUbe.setVisible(true);
                    txtDelCha.setVisible(true);
                    txtTotal.setVisible(true);
                    lblCostp.setVisible(true);
                    lblCosti.setVisible(true);
                    lblItotal.setVisible(true);
                    lblDelCha.setVisible(true);
                    lblTotal.setVisible(true);
                    txtCostp.setVisible(true);
                    txtCosti.setVisible(true);
                    txtItotal.setVisible(true);
                    btnItotal.setVisible(true);
                    btnReset.setVisible(true);
                    btnCheck.setVisible(true);
                    taReceipt.setVisible(true);

                    cbTapsi.setVisible(false);
                    cbLongsi.setVisible(false);
                    cbHotsi.setVisible(false);
                    cbCornsi.setVisible(false);
                    cbTosi.setVisible(false);
                    cbTea.setVisible(false);
                    cbCoke.setVisible(false);
                    cbSprite.setVisible(false);
                    cbJuice.setVisible(false);
                    cbLemon.setVisible(false);
                    txtTapsi.setVisible(false);
                    txtLongsi.setVisible(false);
                    txtHotsi.setVisible(false);
                    txtCornsi.setVisible(false);
                    txtTosi.setVisible(false);
                    txtTea.setVisible(false);
                    txtCoke.setVisible(false);
                    txtSprite.setVisible(false);
                    txtJuice.setVisible(false);
                    txtLemon.setVisible(false);
                    lblTapsi.setVisible(false);
                    lblLongsi.setVisible(false);
                    lblHotsi.setVisible(false);
                    lblCornsi.setVisible(false);
                    lblTosi.setVisible(false);
                    lblTea.setVisible(false);
                    lblCoke.setVisible(false);
                    lblSprite.setVisible(false);
                    lblJuice.setVisible(false);
                    lblLemon.setVisible(false);
                    lblMeal.setVisible(false);
                    lblDrinks.setVisible(false);
                    txtCostm.setVisible(false);
                    txtCostd.setVisible(false);
                    txtItotal2.setVisible(false);
                    txtDelCha2.setVisible(false);
                    txtTotal2.setVisible(false);
                    lblCostm.setVisible(false);
                    lblCostd.setVisible(false);
                    taReceipt2.setVisible(false);
                    taTerms.setVisible(false);
                    lblSlicesmenu.setVisible(false);
                    lblBusolvedmenu.setVisible(false);
                    lblSlices.setVisible(false);
                    lblBusolved.setVisible(false);
                    lblSlicesdes.setVisible(false);
                    lblBusolveddes.setVisible(false);
                    lblFos.setVisible(false);

                    sp.setVisible(false);
                    lblName.setVisible(false);
                    lblAddress.setVisible(false);
                    lblConInfo.setVisible(false);
                    lblImage.setVisible(false);
                    txtName.setVisible(false);
                    txtConInfo.setVisible(false);
                    taAddress.setVisible(false);
                    btnEdit.setVisible(false);
                    btnSend.setVisible(false);
                    cbTerms.setVisible(false);
                    panelUser.setVisible(false);

                    cbHawaiian.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbHawaiian.isSelected()) {
                                txtHawaiian.setEnabled(true);
                            }
                            else {
                                txtHawaiian.setEnabled(false);
                            }
                        }
                    });

                    txtHawaiian.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbHam.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbHam.isSelected()) {
                                txtHam.setEnabled(true);
                            }
                            else {
                                txtHam.setEnabled(false);
                            }
                        }
                    });

                    txtHam.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbCheese.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbCheese.isSelected()) {
                                txtCheese.setEnabled(true);
                            }
                            else {
                                txtCheese.setEnabled(false);
                            }
                        }
                    });

                    txtCheese.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbMeat.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbMeat.isSelected()) {
                                txtMeat.setEnabled(true);
                            }
                            else {
                                txtMeat.setEnabled(false);
                            }
                        }
                    });

                    txtMeat.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbPep.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbPep.isSelected()) {
                                txtPep.setEnabled(true);
                            }
                            else {
                                txtPep.setEnabled(false);
                            }
                        }
                    });

                    txtPep.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbVanilla.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbVanilla.isSelected()) {
                                txtVanilla.setEnabled(true);
                            }
                            else {
                                txtVanilla.setEnabled(false);
                            }
                        }
                    });

                    txtVanilla.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbChocolate.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbChocolate.isSelected()) {
                                txtChocolate.setEnabled(true);
                            }
                            else {
                                txtChocolate.setEnabled(false);
                            }
                        }
                    });

                    txtChocolate.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbStraw.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbStraw.isSelected()) {
                                txtStraw.setEnabled(true);
                            }
                            else {
                                txtStraw.setEnabled(false);
                            }
                        }
                    });

                    txtStraw.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbMango.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbMango.isSelected()) {
                                txtMango.setEnabled(true);
                            }
                            else {
                                txtMango.setEnabled(false);
                            }
                        }
                    });

                    txtMango.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbUbe.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbUbe.isSelected()) {
                                txtUbe.setEnabled(true);
                            }
                            else {
                                txtUbe.setEnabled(false);
                            }
                        }
                    });

                    txtUbe.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                    
                    txtCostp.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                    
                    txtCosti.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                    
                    txtDelCha.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                    
                    txtItotal.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                    
                    txtTotal.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                    
                    taReceipt.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                } //if intIndex == 1

                /*=========================== If Restaurant B ===========================*/
                else if(intIndex == 2) {
                    panelB.setBounds(0, 0, 1000, 700);
                    panelB.setBackground(Color.LIGHT_GRAY);

                    txtCostm.setText("0.00");
                    txtCostd.setText("0.00");
                    txtItotal2.setText("0.00");
                    txtDelCha2.setText("0.00");
                    txtTotal2.setText("0.00");
                    txtTapsi.setText("0");
                    txtLongsi.setText("0");
                    txtHotsi.setText("0");
                    txtCornsi.setText("0");
                    txtTosi.setText("0");
                    txtTea.setText("0");
                    txtCoke.setText("0");
                    txtSprite.setText("0");
                    txtJuice.setText("0");
                    txtLemon.setText("0");
                    taReceipt2.setText(null);

                    cbTapsi.setSelected(false);
                    cbLongsi.setSelected(false);
                    cbHotsi.setSelected(false);
                    cbCornsi.setSelected(false);
                    cbTosi.setSelected(false);
                    cbTea.setSelected(false);
                    cbCoke.setSelected(false);
                    cbSprite.setSelected(false);
                    cbJuice.setSelected(false);
                    cbLemon.setSelected(false);

                    txtTapsi.setEnabled(false);
                    txtLongsi.setEnabled(false);
                    txtHotsi.setEnabled(false);
                    txtCornsi.setEnabled(false);
                    txtTosi.setEnabled(false);
                    txtTea.setEnabled(false);
                    txtCoke.setEnabled(false);
                    txtSprite.setEnabled(false);
                    txtJuice.setEnabled(false);
                    txtLemon.setEnabled(false);

                    panelMenu3.setVisible(true);
                    cboResto.setVisible(true);
                    lblResto.setVisible(true);
                    panelA.setVisible(false);
                    panelB.setVisible(true);
                    panelA.setVisible(false);
                    lblPizza.setVisible(false);
                    lblIcecream.setVisible(false);
                    cbHawaiian.setVisible(false);
                    cbHam.setVisible(false);
                    cbCheese.setVisible(false);
                    txtHawaiian.setVisible(false);
                    cbVanilla.setVisible(false);
                    cbChocolate.setVisible(false);
                    txtHam.setVisible(false);
                    txtCheese.setVisible(false);
                    txtMeat.setVisible(false);
                    txtPep.setVisible(false);
                    txtVanilla.setVisible(false);
                    txtChocolate.setVisible(false);
                    txtStraw.setVisible(false);
                    txtMango.setVisible(false);
                    txtUbe.setVisible(false);
                    cbMeat.setVisible(false);
                    cbPep.setVisible(false);
                    cbStraw.setVisible(false);
                    cbMango.setVisible(false);
                    cbUbe.setVisible(false);
                    lblHawaiian.setVisible(false);
                    lblHam.setVisible(false);
                    lblCheese.setVisible(false);
                    lblMeat.setVisible(false);
                    lblPep.setVisible(false);
                    lblVanilla.setVisible(false);
                    lblChocolate.setVisible(false);
                    lblMango.setVisible(false);
                    lblStraw.setVisible(false);
                    lblUbe.setVisible(false);
                    lblCostp.setVisible(false);
                    lblCosti.setVisible(false);
                    txtCostp.setVisible(false);
                    txtCosti.setVisible(false);
                    txtDelCha.setVisible(false);
                    txtTotal.setVisible(false);
                    txtItotal.setVisible(false);
                    taReceipt.setVisible(false);
                    lblSlicesmenu.setVisible(false);
                    lblBusolvedmenu.setVisible(false);
                    lblBusolved.setVisible(false);
                    lblSlices.setVisible(false);
                    lblSlicesdes.setVisible(false);
                    lblBusolveddes.setVisible(false);
                    lblFos.setVisible(false);

                    btnItotal.setVisible(true);
                    btnReset.setVisible(true);
                    btnCheck.setVisible(true);
                    taReceipt2.setVisible(true);
                    lblItotal.setVisible(true);
                    lblDelCha.setVisible(true);
                    lblTotal.setVisible(true);
                    cbTapsi.setVisible(true);
                    cbLongsi.setVisible(true);
                    cbHotsi.setVisible(true);
                    cbCornsi.setVisible(true);
                    cbTosi.setVisible(true);
                    cbTea.setVisible(true);
                    cbCoke.setVisible(true);
                    cbSprite.setVisible(true);
                    cbJuice.setVisible(true);
                    cbLemon.setVisible(true);
                    txtTapsi.setVisible(true);
                    txtLongsi.setVisible(true);
                    txtHotsi.setVisible(true);
                    txtCornsi.setVisible(true);
                    txtTosi.setVisible(true);
                    txtTea.setVisible(true);
                    txtCoke.setVisible(true);
                    txtSprite.setVisible(true);
                    txtJuice.setVisible(true);
                    txtLemon.setVisible(true);
                    lblTapsi.setVisible(true);
                    lblLongsi.setVisible(true);
                    lblHotsi.setVisible(true);
                    lblCornsi.setVisible(true);
                    lblTosi.setVisible(true);
                    lblTea.setVisible(true);
                    lblCoke.setVisible(true);
                    lblSprite.setVisible(true);
                    lblJuice.setVisible(true);
                    lblLemon.setVisible(true);
                    lblMeal.setVisible(true);
                    lblDrinks.setVisible(true);
                    txtCostm.setVisible(true);
                    txtCostd.setVisible(true);
                    txtItotal2.setVisible(true);
                    txtDelCha2.setVisible(true);
                    txtTotal2.setVisible(true);
                    lblCostm.setVisible(true);
                    lblCostd.setVisible(true);

                    taTerms.setVisible(false);
                    sp.setVisible(false);
                    lblName.setVisible(false);
                    lblAddress.setVisible(false);
                    lblConInfo.setVisible(false);
                    lblImage.setVisible(false);
                    txtName.setVisible(false);
                    txtConInfo.setVisible(false);
                    taAddress.setVisible(false);
                    btnEdit.setVisible(false);
                    btnSend.setVisible(false);
                    cbTerms.setVisible(false);
                    panelUser.setVisible(false);

                    cbTapsi.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbTapsi.isSelected()) {
                                txtTapsi.setEnabled(true);
                            }
                            else {
                                txtTapsi.setEnabled(false);
                            }
                        }
                    });

                    txtTapsi.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbLongsi.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbLongsi.isSelected()) {
                                txtLongsi.setEnabled(true);
                            }
                            else {
                                txtLongsi.setEnabled(false);
                            }
                        }
                    });

                    txtLongsi.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbHotsi.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbHotsi.isSelected()) {
                                txtHotsi.setEnabled(true);
                            }
                            else {
                                txtHotsi.setEnabled(false);
                            }
                        }
                    });

                    txtHotsi.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbCornsi.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbCornsi.isSelected()) {
                                txtCornsi.setEnabled(true);
                            }
                            else {
                                txtCornsi.setEnabled(false);
                            }
                        }
                    });

                    txtCornsi.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbTosi.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbTosi.isSelected()) {
                                txtTosi.setEnabled(true);
                            }
                            else {
                                txtTosi.setEnabled(false);
                            }
                        }
                    });

                    txtTosi.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbTea.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbTea.isSelected()) {
                                txtTea.setEnabled(true);
                            }
                            else {
                                txtTea.setEnabled(false);
                            }
                        }
                    });

                    txtTea.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbCoke.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbCoke.isSelected()) {
                                txtCoke.setEnabled(true);
                            }
                            else {
                                txtCoke.setEnabled(false);
                            }
                        }
                    });

                    txtCoke.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbSprite.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbSprite.isSelected()) {
                                txtSprite.setEnabled(true);
                            }
                            else {
                                txtSprite.setEnabled(false);
                            }
                        }
                    });

                    txtSprite.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbJuice.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbJuice.isSelected()) {
                                txtJuice.setEnabled(true);
                            }
                            else {
                                txtJuice.setEnabled(false);
                            }
                        }
                    });

                    txtJuice.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });

                    cbLemon.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent objAE) {
                            if(cbLemon.isSelected()) {
                                txtLemon.setEnabled(true);
                            }
                            else {
                                txtLemon.setEnabled(false);
                            }
                        }
                    });

                    txtLemon.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                    
                    txtCostm.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                    
                    txtCostd.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                    
                    txtItotal2.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                    
                    txtTotal2.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                    
                    txtDelCha2.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                    
                    taReceipt2.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent objKE) {
                            char charNum = objKE.getKeyChar();
                            if(!(Character.isDigit(charNum)) || Character.isDigit(charNum) ||
                                    (charNum == KeyEvent.VK_BACK_SPACE) ||
                                    (charNum == KeyEvent.VK_DELETE)) {
                                objKE.consume();
                            }
                        }
                        public void keyPressed(KeyEvent e) {}
                        public void keyReleased(KeyEvent e) {}
                    });
                } //if index == 2
            }
        }); //cboResto.addActionListener(new ActionListener()

        /*=========================== Button Total ===========================*/
        btnItotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent objAE) {

                String strResto = (String)cboResto.getSelectedItem();

                if(strResto.equals("Slices and Scoops")) {
                    double dblHawaiian = Double.parseDouble(txtHawaiian.getText());
                    double dblHam = Double.parseDouble(txtHam.getText());
                    double dblCheese = Double.parseDouble(txtCheese.getText());
                    double dblMeat = Double.parseDouble(txtMeat.getText());
                    double dblPep = Double.parseDouble(txtPep.getText());

                    double dblVanilla = Double.parseDouble(txtVanilla.getText());
                    double dblChocolate = Double.parseDouble(txtChocolate.getText());
                    double dblStraw = Double.parseDouble(txtStraw.getText());
                    double dblMango = Double.parseDouble(txtMango.getText());
                    double dblUbe = Double.parseDouble(txtUbe.getText());

                    dblCPizza[0] = (dblHawaiian * dblPriceHawaiian);
                    dblCPizza[1] = (dblHam * dblPriceHam);
                    dblCPizza[2] = (dblCheese * dblPriceCheese);
                    dblCPizza[3] = (dblMeat * dblPriceMeat);
                    dblCPizza[4] = (dblPep * dblPricePep);

                    dblCIce[0] = (dblVanilla * dblPriceVanilla);
                    dblCIce[1] = (dblChocolate * dblPriceChocolate);
                    dblCIce[2] = (dblStraw * dblPriceStraw);
                    dblCIce[3] = (dblMango * dblPriceMango);
                    dblCIce[4] = (dblUbe * dblPriceUbe);

                    dblTotalP = dblCPizza[0] + dblCPizza[2] + dblCPizza[1] + dblCPizza[3] +
                            dblCPizza[4];

                    dblTotalI = dblCIce[0] + dblCIce[1] + dblCIce[2] + dblCIce[3] + dblCIce[4];

                    double dblTotalIP = dblTotalP + dblTotalI;

                    String strIAmount = String.format("%.2f", dblTotalP);
                    txtCostp.setText(strIAmount);

                    String strIAmountI = String.format("%.2f", dblTotalI);
                    txtCosti.setText(strIAmountI);

                    dblAmount = dblDelCha + dblTotalIP;
                    txtDelCha.setText(String.format("%.2f", dblDelCha));
                    String strAmount = String.format("%.2f", dblAmount);
                    txtTotal.setText(strAmount);

                    dblTotal[0] = Double.parseDouble(txtCostp.getText());
                    dblTotal[1] = Double.parseDouble(txtCosti.getText());

                    double dblTotal1 = (dblTotal[0] + dblTotal[1]);
                    double dblsubTotal = (dblTotal1);
                    String strsubTotal = String.format("%.2f", dblsubTotal);
                    txtItotal.setText(strsubTotal);
                } //if(strResto.equals("Slices and Scoops"))

                else if(strResto.equals("Busolved")) {
                    double dblTapsi = Double.parseDouble(txtTapsi.getText());
                    double dblLongsi = Double.parseDouble(txtLongsi.getText());
                    double dblHotsi = Double.parseDouble(txtHotsi.getText());
                    double dblCornsi = Double.parseDouble(txtCornsi.getText());
                    double dblTosi= Double.parseDouble(txtTosi.getText());

                    double dblTea = Double.parseDouble(txtTea.getText());
                    double dblCoke = Double.parseDouble(txtCoke.getText());
                    double dblSprite = Double.parseDouble(txtSprite.getText());
                    double dblJuice = Double.parseDouble(txtJuice.getText());
                    double dblLemon = Double.parseDouble(txtLemon.getText());

                    dblCMeal[0] = (dblTapsi * dblPriceTapsi);
                    dblCMeal[1] = (dblLongsi * dblPriceLongsi);
                    dblCMeal[2] = (dblHotsi * dblPriceHotsi);
                    dblCMeal[3] = (dblCornsi * dblPriceCornsi);
                    dblCMeal[4] = (dblTosi * dblPriceTosi);

                    dblCDrink[0] = (dblTea * dblPriceTea);
                    dblCDrink[1] = (dblCoke * dblPriceCoke);
                    dblCDrink[2] = (dblSprite * dblPriceSprite);
                    dblCDrink[3] = (dblJuice * dblPriceJuice);
                    dblCDrink[4] = (dblLemon * dblPriceLemon);

                    dblTotalM = dblCMeal[0] + dblCMeal[2] + dblCMeal[1] + dblCMeal[3] +
                            dblCMeal[4];

                    dblTotalD = dblCDrink[0] + dblCDrink[1] + dblCDrink[2] + dblCDrink[3] +
                            dblCDrink[4];

                    double dblTotalMD = dblTotalM + dblTotalD;

                    String strIAmountM = String.format("%.2f", dblTotalM);
                    txtCostm.setText(strIAmountM);

                    String strIAmountD = String.format("%.2f", dblTotalD);
                    txtCostd.setText(strIAmountD);

                    dblAmount2 = dblDelCha + dblTotalMD;
                    txtDelCha2.setText(String.format("%.2f", dblDelCha2));
                    String strAmount2 = String.format("%.2f", dblAmount2);
                    txtTotal2.setText(strAmount2);

                    dblTotal2[0] = Double.parseDouble(txtCostm.getText());
                    dblTotal2[1] = Double.parseDouble(txtCostd.getText());

                    double dblTotal = (dblTotal2[0] + dblTotal2[1]);
                    double dblsubTotal2 = (dblTotal);
                    String strsubTotal2 = String.format("%.2f", dblsubTotal2);
                    txtItotal2.setText(strsubTotal2);
                } //else if(strResto.equals("Busolved"))

            }
        }); //btnItotal.addActionListener(new ActionListener()

        /*=========================== Button Reset ===========================*/
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent objAE) {
                String strResto = (String)cboResto.getSelectedItem();

                if(strResto.equals("Slices and Scoops")) {
                    txtCostp.setText("0.00");
                    txtCosti.setText("0.00");
                    txtDelCha.setText("0.00");
                    txtItotal.setText("0.00");
                    txtTotal.setText("0.00");
                    txtHawaiian.setText("0");
                    txtHam.setText("0");
                    txtCheese.setText("0");
                    txtMeat.setText("0");
                    txtPep.setText("0");
                    txtVanilla.setText("0");
                    txtChocolate.setText("0");
                    txtStraw.setText("0");
                    txtMango.setText("0");
                    txtUbe.setText("0");
                    taReceipt.setText(null);

                    cbHam.setSelected(false);
                    cbCheese.setSelected(false);
                    cbHawaiian.setSelected(false);
                    cbMeat.setSelected(false);
                    cbPep.setSelected(false);
                    cbVanilla.setSelected(false);
                    cbChocolate.setSelected(false);
                    cbStraw.setSelected(false);
                    cbMango.setSelected(false);
                    cbUbe.setSelected(false);

                    txtHawaiian.setEnabled(false);
                    txtHam.setEnabled(false);
                    txtCheese.setEnabled(false);
                    txtPep.setEnabled(false);
                    txtMeat.setEnabled(false);
                    txtVanilla.setEnabled(false);
                    txtChocolate.setEnabled(false);
                    txtStraw.setEnabled(false);
                    txtMango.setEnabled(false);
                    txtUbe.setEnabled(false);
                    btnCheck.setEnabled(true);
                    btnItotal.setEnabled(true);
                } //if(strResto.equals("Slices and Scoops"))

                else if(strResto.equals("Busolved")) {
                    txtCostm.setText("0.00");
                    txtCostd.setText("0.00");
                    txtItotal2.setText("0.00");
                    txtDelCha2.setText("0.00");
                    txtTotal2.setText("0.00");
                    txtTapsi.setText("0");
                    txtLongsi.setText("0");
                    txtHotsi.setText("0");
                    txtCornsi.setText("0");
                    txtTosi.setText("0");
                    txtTea.setText("0");
                    txtCoke.setText("0");
                    txtSprite.setText("0");
                    txtJuice.setText("0");
                    txtLemon.setText("0");
                    taReceipt2.setText(null);

                    cbTapsi.setSelected(false);
                    cbLongsi.setSelected(false);
                    cbHotsi.setSelected(false);
                    cbCornsi.setSelected(false);
                    cbTosi.setSelected(false);
                    cbTea.setSelected(false);
                    cbCoke.setSelected(false);
                    cbSprite.setSelected(false);
                    cbJuice.setSelected(false);
                    cbLemon.setSelected(false);

                    txtTapsi.setEnabled(false);
                    txtLongsi.setEnabled(false);
                    txtHotsi.setEnabled(false);
                    txtCornsi.setEnabled(false);
                    txtTosi.setEnabled(false);
                    txtTea.setEnabled(false);
                    txtCoke.setEnabled(false);
                    txtSprite.setEnabled(false);
                    txtJuice.setEnabled(false);
                    txtLemon.setEnabled(false);
                    btnItotal.setEnabled(true);
                } //else if(strResto.equals("Busolved"))

            }
        }); //btnReset.addActionListener(new ActionListener()

        /*=========================== Button Checkout ===========================*/
        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent objAE) {
                String strResto = (String)cboResto.getSelectedItem();
                strName = txtName.getText();
                strConts = txtConInfo.getText();
                strAddress = taAddress.getText();

                int intRef, intDeliver;
                intRef = 1000 + (int) (Math.random()*9999);
                int intRef1 = (intRef);

                intDeliver = 50 + (int) (Math.random()* 120);
                int intDeliver1 = (intDeliver);

                Calendar timer = Calendar.getInstance();
                timer.getTime();
                SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
                SimpleDateFormat sdfDate = new SimpleDateFormat("MM-dd-yyyy");
                sdfDate.format(timer.getTime());

                if(strResto.equals("Slices and Scoops")) {
                    if(txtTotal.getText().equals("0.00")) {
                        JOptionPane.showMessageDialog(null, "Please try Again.",
                                "Error!", JOptionPane.ERROR_MESSAGE);
                    } //if(txtTotal.getText().equals("0.00"))
                    else {
                        intPizza[0] = Integer.parseInt(txtHawaiian.getText());
                        intPizza[1] = Integer.parseInt(txtHam.getText());
                        intPizza[2] = Integer.parseInt(txtCheese.getText());
                        intPizza[3] = Integer.parseInt(txtMeat.getText());
                        intPizza[4] = Integer.parseInt(txtPep.getText());

                        intIce[0] = Integer.parseInt(txtVanilla.getText());
                        intIce[1] = Integer.parseInt(txtChocolate.getText());
                        intIce[2] = Integer.parseInt(txtStraw.getText());
                        intIce[3] = Integer.parseInt(txtMango.getText());
                        intIce[4] = Integer.parseInt(txtUbe.getText());

                        //(txtConInfo);
                        //(taAddress);
                        int intAns = JOptionPane.showConfirmDialog(null, "Do you want to checkout your order/s?", "Checkout Confirmation",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if(intAns == JOptionPane.YES_NO_OPTION) {
                            JOptionPane.showMessageDialog(null,"Thank you for Choosing Slices and Scoops! Your estimated Delivery time is "
                                    + intDeliver1  + " Minutes.", "Thank You!", JOptionPane.WARNING_MESSAGE);
                            taReceipt.append("\t            Food Ordering System\n\n" +
                                    "================================================" +
                                    "\nName: "+ strName +
                                    "\nContact Number: " + strConts +
                                    "\nAddress: " + strAddress +
                                    "\nReference:\t\t" + intRef1 +
                                    "\n ================================================\n" +
                                    " Item\t\tQty.\tPrice" +
                                    "\n Hawaiian Pizza:\t" + intPizza[0] + "\t" + dblCPizza[0] +
                                    "\n Ham and Cheese Pizza:\t" + intPizza[1] + "\t" + dblCPizza[1] +
                                    "\n Cheese Pizza:\t\t" + intPizza[2] + "\t" + dblCPizza[2] +
                                    "\n Meat Lover Pizza:\t" + intPizza[3] + "\t" + dblCPizza[3] +
                                    "\n Pepperoni Pizza:\t" + intPizza[4] + "\t" + dblCPizza[4] +
                                    "\n Vanilla Ice Cream:\t" + intIce[0] + "\t" + dblCIce[0] +
                                    "\n Chocolate Ice Cream:\t" + intIce[1] + "\t" + dblCIce[1] +
                                    "\n Strawberry Ice Cream:\t" + intIce[2] + "\t" + dblCIce[2] +
                                    "\n Mango Ice Cream:\t" + intIce[3] + "\t" + dblCIce[3] +
                                    "\n Ube Ice Cream:\t" + intIce[4] + "\t" + dblCIce[4] +
                                    "\n\n  Delivery Charge:\t40.00" +
                                    "\n  Total:\t\t" + dblAmount +
                                    "\n ================================================\n" +
                                    "\n  Date:\t\t" + sdfDate.format(timer.getTime()) +
                                    "\n  Time:\t\t" + sdfTime.format(timer.getTime()) +
                                    "\n  Estimated Delivery Time:\t" + intDeliver1 + " Minutes");
                        }
                    } //else
                } //if(strResto.equals("Slices and Scoops"))

                else if(strResto.equals("Busolved")) {
                    if(txtTotal2.getText().equals("0.00")) {
                        JOptionPane.showMessageDialog(null, "Please try Again.",
                                "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    else {

                        int intAns2 = JOptionPane.showConfirmDialog(null, "Do you want to checkout your order/s?", "Checkout Confirmation",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if(intAns2 == JOptionPane.YES_NO_OPTION) {
                            JOptionPane.showMessageDialog(null,"Thank you for Choosing Busolved! Your estimated Delivery time is "
                                    + intDeliver1  + " Minutes.", "Thank You!", JOptionPane.WARNING_MESSAGE);
                            intMeal[0] = Integer.parseInt(txtTapsi.getText());
                            intMeal[1] = Integer.parseInt(txtLongsi.getText());
                            intMeal[2] = Integer.parseInt(txtHotsi.getText());
                            intMeal[3] = Integer.parseInt(txtCornsi.getText());
                            intMeal[4] = Integer.parseInt(txtTosi.getText());

                            intDrink[0] = Integer.parseInt(txtTea.getText());
                            intDrink[1] = Integer.parseInt(txtCoke.getText());
                            intDrink[2] = Integer.parseInt(txtSprite.getText());
                            intDrink[3] = Integer.parseInt(txtJuice.getText());
                            intDrink[4] = Integer.parseInt(txtLemon.getText());
                            taReceipt2.append("\t            Food Ordering System\n\n" +
                                    "================================================" +
                                    "\nName: "+ strName +
                                    "\nContact Number: " + strConts +
                                    "\nAddress: " + strAddress +
                                    "\nReference:\t\t" + intRef1 +
                                    "\n ================================================\n" +
                                    " Item\t\tQty.\tPrice" +
                                    "\n Tapsilog:\t\t" + intMeal[0] + "\t" + dblCMeal[0] +
                                    "\n Longsilog:\t\t" + intMeal[1] + "\t" + dblCMeal[1] +
                                    "\n Hotsilog:\t\t" + intMeal[2] + "\t" + dblCMeal[2] +
                                    "\n Cornsilog:\t\t" + intMeal[3] + "\t" + dblCMeal[3] +
                                    "\n Tosilog:\t\t" + intMeal[4] + "\t" + dblCMeal[4] +
                                    "\n Iced Tea:\t\t" + intDrink[0] + "\t" + dblCDrink[0] +
                                    "\n Coke in Can:\t\t" + intDrink[1] + "\t" + dblCDrink[1] +
                                    "\n Sprite in Can:\t\t" + intDrink[2] + "\t" + dblCDrink[2] +
                                    "\n Orange Juice:\t\t" + intDrink[3] + "\t" + dblCDrink[3] +
                                    "\n Lemonade:\t\t" + intDrink[4] + "\t" + dblCDrink[4] +
                                    "\n\n  Delivery Charge:\t40.00" +
                                    "\n  Total:\t\t" + dblAmount2 +
                                    "\n ================================================\n" +
                                    "\n  Date:\t\t" + sdfDate.format(timer.getTime()) +
                                    "\n  Time:\t\t" + sdfTime.format(timer.getTime()) +
                                    "\n  Estimated Delivery Time:\t" + intDeliver1 + " Minutes");
                        }
                    } //else
                } //else if(strResto.equals("Busolved"))
            }
        }); //btnCheck.addActionListener(new ActionListener()
    } //FoodOrderingSystem()

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FoodOrderingSystem();
            }
        });
    }
} //public class FoodOrderingSystem

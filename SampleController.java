package application;

import java.io.File;
import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.util.Duration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import org.hibernate.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class SampleController implements Initializable {

    // ------------------------------------------------------------------------------------ //
    // Varibules //
    // ------------------------------------------------------------------------------------ //
    private Stage stage;
    private Scene scene;
    private Parent root;

    // first page
    @FXML
    private Label clickMe1;

    @FXML
    private Label clickMe2;

    @FXML
    private Button loginBotton1;

    @FXML
    private BorderPane rootpane;

    @FXML
    private Button signUpBotton1;

    // sign up page 
    @FXML
    private TextField LastName;

    @FXML
    ComboBox<String> comboBox = new ComboBox<>();

    @FXML
    private DatePicker datePokerTextFiled;

    @FXML
    private TextField firstName;

    @FXML
    private TextField phoneNoTextFiled;

    @FXML
    private Label signUpMassageLable;

    @FXML
    private Label signUpMassageLable2;

    @FXML
    private Button signUpPage;

    @FXML
    private TextField userEmail;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField userPassword;

    @FXML
    private Button cancelButton;

    // login page
    @FXML
    private Button LoginBotton2;

    @FXML
    private Label LoginMassgeLable;

    @FXML
    private PasswordField PasswordLoginTextField;

    @FXML
    private TextField loginUserName;

    // home page
    @FXML
    private Label fakelabel;
    @FXML
    private Button favoirteButton;

    @FXML
    private Button formButton;

    @FXML
    private Button homePageButton;

    @FXML
    private Button petServiseButton;

    @FXML
    private Button petServiseButton1;

    // PutUp4Adoption page
    @FXML
    private Button PetFormSubmit;

    @FXML
    private RadioButton female;

    @FXML
    private ToggleGroup genderPet;

    @FXML
    private RadioButton male;

    @FXML
    private TextField petAgeUser;

    @FXML
    private TextField petBreedUser;

    @FXML
    private TextArea petDescriptionUser;

    @FXML
    private TextField petIDUser;

    @FXML
    private TextField petImage;

    @FXML
    private TextField petNameUser;

    public String[] petTypes = {"Cat", "Dog", "Reptile", "Small Animal"};
    public ObservableList<String> petType = FXCollections.observableArrayList(petTypes);
    @FXML
    private ComboBox<String> petTypeUser = new ComboBox<>();

    //@FXML
    //private Button homePageButton;
    //ClinicList page 
    @FXML
    ComboBox<String> area = new ComboBox<>();

    @FXML
    private Text contact1;

    @FXML
    private Text contact2;

    @FXML
    private Text contact3;

    @FXML
    private Text contact4;

    @FXML
    private Text jedLab1;

    @FXML
    private Text jedLab2;

    @FXML
    private Text jedLab3;

    @FXML
    private Text jedlab4;

    @FXML
    private Text jedlab5;

    @FXML
    private Text jedlab6;

    @FXML
    private Text jedlab7;

    @FXML
    private Text jedlab8;

    @FXML
    private Text safeClincTime;

    @FXML
    private DatePicker birthDateUpDate;

    @FXML
    ComboBox<String> cityUpDate = new ComboBox<>();

    @FXML
    private TextField emailUpDate;

    @FXML
    private TextField firstNameUpDate;

    @FXML
    private TextField lastNameUpDate;

    @FXML
    private PasswordField passwordUpDate;

    @FXML
    private TextField phoneNoUpData;

    @FXML
    private Button updateinfo;

    @FXML
    private TextField userNameUpDate;

    @FXML
    private ImageView CatImage2;

    @FXML
    private CheckBox consent1;

    @FXML
    private CheckBox consent2;

    @FXML
    ComboBox<String> combo_box = new ComboBox<>();

    @FXML
    ComboBox<String> combo_box1 = new ComboBox<>();

    @FXML
    ComboBox<String> combo_box2 = new ComboBox<>();

    @FXML
    VBox button;
    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Button b4;
    @FXML
    Button b5;
    @FXML
    Button b6;
    @FXML
    Button b7;

    @FXML
    public String[] CityItems = {"Makkah", "Jeddah", "Riyadh", "Alkhobar", "Dammam", "AlMadinah AlMunawwarah", "Al-Qassim"};
    public ObservableList<String> city = FXCollections.observableArrayList(CityItems);

    @FXML
    public TextField Ageuser;

    @FXML
    private Label UserNameLable;

    @FXML
    private ImageView petImageUser;

    @FXML
    private Label homeMassageLable = new Label();

    @FXML
    private ImageView CatImage1;

    String username;
    String password;
    String FFName;
    String i;
    Image h;

    String ddusername;

    // MyProfile page 
    @FXML
    private Label firstNameProfile;

    @FXML
    private Label lastNameProfile;

    @FXML
    private Label userNameProfile;

    @FXML
    private Label emailProfile;

    @FXML
    private Label birthDateProfile;

    @FXML
    private Label cityProfile;

    @FXML
    private Label passwordProfile;

    @FXML
    private Button updateBotton;

    @FXML
    private Button DelBotton;

    @FXML
    private Label labal1;

    @FXML
    private Label labal2;

    @FXML
    private Label labal3;

    @FXML
    private Label labal4;

    @FXML
    private Label labal5;

    @FXML
    private Label labal6;

    @FXML
    private Label labal7;

    @FXML
    private Label petdescription;

    @FXML
    private ImageView closePetPhoto;

    @FXML
    private Label petage;

    @FXML
    private Label petbreed;

    @FXML
    private Label petgender;

    @FXML
    private Label petname;

    static int o;

    @FXML
    private ImageView DogImage1;

    @FXML
    private Label DogAge;

    @FXML
    private Label DogBreed;

    @FXML
    private Label DogDescription;

    @FXML
    private Label DogGender;

    @FXML
    private Label DogName;

    @FXML
    private ImageView DogPhoto;

    @FXML
    private Button AdoptButtonHomePage;

    @FXML
    private Button clinicButton;

    @FXML
    private Button AdopitSmallPet;

    @FXML
    private Button showSmallPetbutton;

    @FXML
    private Label smallPetAge;

    @FXML
    private Label smallPetBreed;

    @FXML
    private Label smallPetDiscripiton;

    @FXML
    private ImageView smallPetImage;

    @FXML
    private Label smallPetSex;

    @FXML
    private ImageView SmallPetImage1;

    @FXML
    private Label Smallpetname;

    @FXML
    private Button proceedButtonConsent;

    @FXML
    private Label catAge2;

    @FXML
    private Label catBreed2;

    @FXML
    private Label catDiscrepiton2;

    @FXML
    private ImageView catImage2;

    @FXML
    private Label catSex2;

    @FXML
    private Button showCat2;

    @FXML
    private Label Catname;

    @FXML
    private Button bbb;

    @FXML
    private Button cancelLogin;

    // reptileInfo page
    @FXML
    private ImageView ReptilesImage1;

    @FXML
    private Label reptileAge;

    @FXML
    private Label reptileBreed;

    @FXML
    private Label reptileDiscription;

    @FXML
    private ImageView reptileImage;

    @FXML
    private Label reptileName;

    @FXML
    private Label reptileSex;

    @FXML
    private Button showreptile;

    @FXML
    private  Button showButton;
    User user = new User();
    POJOPet pe = new POJOPet();

    @FXML
    private Label lableSign1;

    @FXML
    private Label lableSign2;

    @FXML
    private Label welcomeLable;

    @FXML
    MediaPlayer mediaPlayer;

    @FXML
    private Label phoneNumber;

    @FXML
    private Label phoneProfile;

    // ------------------------------------------------------------------------------------ //
    // Actions & events & handling & database & switching sceenes fxml //
    // ------------------------------------------------------------------------------------ //
    public void userData(String userName) {
        this.username = userName;
        UserClass.setUser_Name(userName);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        area.setItems(city);
        combo_box1.setItems(city);
        comboBox.setItems(city);
        cityUpDate.setItems(city);
        area.setItems(city);
        petTypeUser.setItems(petType);
        homeMassageLable.setText("Hello" + " " + UserClass.getUser_Name());
    }

    // in the first page
    @FXML
    public void signUp(ActionEvent event) throws IOException {

        Parent r = FXMLLoader.load(getClass().getResource("signup_page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(r);
        stage.setScene(scene);
        stage.show();
    }

    // in the first page
    @FXML
    public void loginButtonClicked(ActionEvent event) throws IOException {
        Parent r = FXMLLoader.load(getClass().getResource("login_page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(r);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cancelButtonOnAction(ActionEvent event) throws IOException {
        Parent r = FXMLLoader.load(getClass().getResource("first_page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(r);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void signUpPage(ActionEvent event) throws IOException {
        signUpMassageLable.setWrapText(true);
        signUpMassageLable.setStyle("-fx-font: 12 ariel;");

        if (firstName.getText().equals("") || LastName.getText().equals("") || userEmail.getText().equals("") || userName.getText().equals("") || userPassword.getText().equals("") || phoneNoTextFiled.getText().equals("")) {
            signUpMassageLable.setText(" Please Fill The Blanks  "); // if the text filed is empty
        } else if (!phoneNoTextFiled.getText().matches("^[0-9]+$")) {
            signUpMassageLable.setText(" Mobile number must be digit only ");    // if the user entered characters not digits{
        } else if (phoneNoTextFiled.getText().length() != 10) {
            signUpMassageLable.setText(" The length of mobile number must be 10 digits ");
        } else if (!firstName.getText().matches("[a-zA-Z]+")) {
            signUpMassageLable.setText(" The first name must be Characters only ");
        } else if (!LastName.getText().matches("[a-zA-Z]+")) {
            signUpMassageLable.setText(" The last name must be Characters only ");
        } else if (!userPassword.getText().matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
            signUpMassageLable.setText("Password must contain at least 8 characters,\nincluding at least one digit,\none letter and one special character!");
        } else if (!userEmail.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            signUpMassageLable.setText("Sorry. Your email must look like: yorname@example.com");

        } else if (userName.getText().length() < 6) {
            signUpMassageLable.setText("User name should be at least 6 characters long.");

        } else if (!userName.getText().matches("[a-zA-Z0-9]+")) {
            signUpMassageLable.setText("User name should contain only letters and digits.");

        } else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List<User> sList = null;
            String queryStr = "from User";
            Query query = session.createQuery(queryStr);
            sList = query.list();
            session.close();
            for (User u : sList) {
                if (u.getUserName().equals(userName.getText())) {
                    signUpMassageLable.setText("Username already exists.Please choose another one.");
                }
            }
            Session ADDsession = HibernateUtil.getSessionFactory().openSession();
            Transaction Addt = ADDsession.beginTransaction();
            User user = new User();
            user.setUserName(userName.getText());
            user.setFirstName(firstName.getText());
            user.setLastName(LastName.getText());
            user.setEmail(userEmail.getText());
            user.setPassword(userPassword.getText());
            user.setPhonoNumber(Integer.parseInt(phoneNoTextFiled.getText()));
            user.setCity(comboBox.getValue());
            user.setDateOfBirth(datePokerTextFiled.getValue().toString());
            //ddusername=user.getUserName();
            UserClass.setUser_Name(user.getUserName());
            username = UserClass.getUser_Name();

            ADDsession.save(user);
            Addt.commit();
            ADDsession.close();
            
           

            /*
            Alert noConsent = new Alert(AlertType.CONFIRMATION);
            noConsent.setTitle("Registration Successful!");
            noConsent.setContentText("Welcome dear " + firstName.getText() + " " + LastName.getText());
            noConsent.showAndWait();
             */
            // ------------------------------------------ //
                          // binding  //
            // ------------------------------------------ //
            signUpMassageLable.setVisible(false);
            lableSign1.setText("Hello  ");
            lableSign2.textProperty().bind(firstName.textProperty());
            PauseTransition pause1 = new PauseTransition(Duration.minutes(2.0));
            pause1.play();

          //signUpMassageLable.setText("You have been registered successfully dear  " + userName.getText());
            PauseTransition pause2 = new PauseTransition(Duration.seconds(2.0));
            pause2.play();
            pause2.setOnFinished(e -> {
                FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("home_page.fxml"));
            Parent root;
                try {
                    root = loader.load();
                
            Scene scene = new Scene(root);
            //accsess the controller
            SampleController home = loader.getController();
            home.loadData(username);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            } catch (IOException ex) {
                    Logger.getLogger(SampleController.class.getName()).log(Level.SEVERE, null, ex);
                }
               

            });

            // ------------------------------------------ //
                           // binding  //
            // ------------------------------------------ //
            

        }
    }
    

    @FXML
    void LoginBottonPage(ActionEvent event) throws IOException {
        LoginMassgeLable.setWrapText(true);
        LoginMassgeLable.setStyle("-fx-font: 12 ariel;");

        if (loginUserName.getText().equals("") || PasswordLoginTextField.getText().equals("")) {
            LoginMassgeLable.setText("Please Fill The Blank!");

        } else if (!PasswordLoginTextField.getText().matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
            LoginMassgeLable.setText("Password must contain at least 8 characters,\nincluding at least one digit,\none letter and one special character!");
            LoginMassgeLable.setWrapText(true);
        } else if (loginUserName.getText().length() < 6) {
            LoginMassgeLable.setText("User name should be at least 6 characters long.");

        } else if (!loginUserName.getText().matches("[a-zA-Z0-9]+")) {
            LoginMassgeLable.setText("User name should contain only letters and digits.");

        } else {

            Session session = HibernateUtil.getSessionFactory().openSession();
            List<User> sList = null;
            Query query = session.createQuery("from User");
            sList = query.list();
            UserClass.setUser_Name(username);
            session.close();
            for (User u : sList) {
                u.getUserName();
                u.getPassword();
            }

            boolean flag = true;
            for (User u : sList) {
                //if user found 
                if ((u.getUserName().equals(loginUserName.getText()) && u.getPassword().equals(PasswordLoginTextField.getText()))) {
                    flag = true;
                    UserClass.setUser_Name(loginUserName.getText());
                    UserClass.setPassword_U(PasswordLoginTextField.getText());

                    username = UserClass.getUser_Name();
                    this.password = UserClass.getPassword_U();

                    /*
                    UserClass.setUser_Name(u.getUserName());
                    Alert noConsent = new Alert(AlertType.CONFIRMATION);
                    noConsent.setTitle("Log in Successful!");
                    noConsent.setContentText("Welcome Back " + loginUserName.getText());
                    noConsent.showAndWait();
                     */
                    // ------------------------------------------ //
                    // binding  //
                    // ------------------------------------------ //
                    LoginMassgeLable.setVisible(false);
                    welcomeLable.setText("Log in Successful!  ");
                    UserNameLable.textProperty().bind(loginUserName.textProperty());
                    PauseTransition pause1 = new PauseTransition(Duration.seconds(1.0));
                    pause1.play();

                    //signUpMassageLable.setText("You have been registered successfully dear  " + userName.getText());
                    PauseTransition pause2 = new PauseTransition(Duration.seconds(1.0));
                    pause2.play();
                    pause2.setOnFinished(e -> {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("home_page.fxml"));
                        Parent root;
                        try {
                            root = loader.load();

                            Scene scene = new Scene(root);
                            //accsess the controller
                            SampleController home = loader.getController();
                            home.loadData(username);
                            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            window.setScene(scene);
                        } catch (IOException ex) {
                            Logger.getLogger(SampleController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    });


                    

                } else {
                    LoginMassgeLable.setText("We do not have Username, please go to Sign Up");
                }

            }
        }
    }

    @FXML
    public void switchPutUp4Adoption(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("PutUp4Adoption.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToClinicsHome(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("ClinicsHome.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToHomePages(ActionEvent event) throws IOException {

        Parent root = (Parent) FXMLLoader.load(getClass().getResource("home_page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToPetType_Page(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PetType_Page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);// Create a scene and place it in the stage
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToProfile(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Account_Info.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        home.loadData(username);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    // clinic list
    public void changeCombo(ActionEvent event) throws IOException {
        switch (area.getValue()) {
            case "Makkah": {
                jedLab1.setText("Address: Alawali Makkah");
                jedLab2.setText("location:  Makkah Saudi Arabia");
                jedLab3.setText("Address: Alzaher Makkah  ");
                jedlab4.setText("location:  Makkah Saudi Arabia");
                jedlab5.setText("Address: Alnuzha Makkah  ");
                jedlab6.setText("location:  Makkah Saudi Arabia");
                jedlab7.setText("Address Alzaidi Makkah");
                jedlab8.setText("location:  Makkah Saudi Arabia");
                safeClincTime.setText("open 24 hours");
                contact1.setText("Contact Number: 966552250933");
                contact2.setText("Contact Number: 966556789921");
                contact3.setText("Contact Number: 966542289213");
                contact4.setText("Contact Number: 966537728281");
            }

            break;
            case "Jeddah": {
                jedLab1.setText("Address: Rouwias Jeddah");
                jedLab2.setText("location:  Jeddah Saudi Arabia");
                jedLab3.setText("Address: Salama Jeddah  ");
                jedlab4.setText("location:  Jeddah Saudi Arabia");
                jedlab5.setText("Address: Mushrifah Jeddah  ");
                jedlab6.setText("location:  Jeddah Saudi Arabia");
                jedlab7.setText("Address Alhamra Jeddah");
                jedlab8.setText("location:  Jeddah Saudi Arabia");
                safeClincTime.setText("open 24 hours");
                contact1.setText("Contact Number: 966555522598");
                contact2.setText("Contact Number: 966552419922");
                contact3.setText("Contact Number: 966569949431");
                contact4.setText("Contact Number: 966567892013");
            }
            break;
            case "Riyadh": {
                jedLab1.setText("Address: Laban Riyadh");
                jedLab2.setText("location:  Riyadh Saudi Arabia");
                jedLab3.setText("Address: Qurtubah Riyadh  ");
                jedlab4.setText("location:  Riyadh Saudi Arabia");
                jedlab5.setText("Address: Sulimaniyah Riyadh  ");
                jedlab6.setText("location:  Riyadh Saudi Arabia");
                jedlab7.setText("Address Alolya Riyadh");
                jedlab8.setText("location:  Riyadh Saudi Arabia");
                safeClincTime.setText("open 24 hours");
                contact1.setText("Contact Number: 966555522598");
                contact2.setText("Contact Number: 966552419922");
                contact3.setText("Contact Number: 966569949431");
                contact4.setText("Contact Number: 966567892013");
            }
            break;
            case "Alkhobar": {
                jedLab1.setText("Address: Al Khuzama Alkhobar");
                jedLab2.setText("location:  Alkhobar Saudi Arabia");
                jedLab3.setText("Address: Iskan Alkhobar  ");
                jedlab4.setText("location:  Alkhobar Saudi Arabia");
                jedlab5.setText("Address: Aljisr Alkhobar  ");
                jedlab6.setText("location:  Alkhobar Saudi Arabia");
                jedlab7.setText("Address Al-Thuqbah  Alkhobar");
                jedlab8.setText("location:  Alkhobar Saudi Arabia");
                safeClincTime.setText("open 24 hours");
                contact1.setText("Contact Number: 966555522598");
                contact2.setText("Contact Number: 966552419922");
                contact3.setText("Contact Number: 966569949431");
                contact4.setText("Contact Number: 966567892013");
            }
            break;
            case "AlMadinah AlMunawwarah": {
                jedLab1.setText("Address: Sultana Street");
                jedLab2.setText("location:  AlMadinah Saudi Arabia");
                jedLab3.setText("Address: Ad difa AlMadinah  ");
                jedlab4.setText("location:  AlMadinah Saudi Arabia");
                jedlab5.setText("Address: Al Jabirah Street  ");
                jedlab6.setText("location:  AlMadinah Saudi Arabia");
                jedlab7.setText("Address Alhamra Street");
                jedlab8.setText("location:  AlMadinah Saudi Arabia");
                safeClincTime.setText("open 24 hours");
                contact1.setText("Contact Number: 966555522598");
                contact2.setText("Contact Number: 966552419922");
                contact3.setText("Contact Number: 966569949431");
                contact4.setText("Contact Number: 966567892013");
            }
            break;
            case "Dammam": {
                jedLab1.setText("Address: Al Faisaliyah Street");
                jedLab2.setText("location:  Dammam Saudi Arabia");
                jedLab3.setText("Address: Alnada Street  ");
                jedlab4.setText("location:  Dammam Saudi Arabia");
                jedlab5.setText("Address: Almanar Street  ");
                jedlab6.setText("location:  Dammam Saudi Arabia");
                jedlab7.setText("Address Alhamra Street");
                jedlab8.setText("location:  Dammam Saudi Arabia");
                safeClincTime.setText("open 24 hours");
                contact1.setText("Contact Number: 966555522598");
                contact2.setText("Contact Number: 966552419922");
                contact3.setText("Contact Number: 966569949431");
                contact4.setText("Contact Number: 966567892013");
            }
            break;
            case "Al-Qassim": {
                jedLab1.setText("Address: Al naziyah Street");
                jedLab2.setText("location:  Buraydah Saudi Arabia");
                jedLab3.setText("Address: Alwrood Street  ");
                jedlab4.setText("location:  Buraydah Saudi Arabia");
                jedlab5.setText("Address: Albsateen Street  ");
                jedlab6.setText("location:  Buraydah Saudi Arabia");
                jedlab7.setText("Address An naseem Street");
                jedlab8.setText("location:  Buraydah Saudi Arabia");
                safeClincTime.setText("open 24 hours");
                contact1.setText("Contact Number: 966555522598");
                contact2.setText("Contact Number: 966552419922");
                contact3.setText("Contact Number: 966569949431");
                contact4.setText("Contact Number: 966567892013");
            }

            break;

        }
    }

    @FXML
    void backToHomePage(ActionEvent event) throws IOException {
        Parent petCare_pageParent = FXMLLoader.load(getClass().getResource("home_page.fxml"));
        Scene petCare_pageScene = new Scene(petCare_pageParent);
        Stage windo = (Stage) ((Node) event.getSource()).getScene().getWindow();

        windo.setScene(petCare_pageScene);
        windo.show();
    }

    public void switchToPetInfo(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("PetInfo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToConsent(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("Consent.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToAdoptionApplicants(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("AdoptionApplicants.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToAdoptionForm(ActionEvent event) throws IOException {
        if (consent1.isSelected() && consent2.isSelected()) {
            Parent root = (Parent) FXMLLoader.load(getClass().getResource("AdoptionForm.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            Alert noConsent = new Alert(AlertType.ERROR);
            noConsent.setTitle("Error Message");
            noConsent.setContentText("You must check all boxes to continue!");
            noConsent.showAndWait();

        }
    }

    public void switchToAdoptionType(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("AdoptionType_Page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToClinicsList(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("ClinicList.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToAdoptionType_Page(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdoptionType_Page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);// Create a scene and place it in the stage
        stage.setScene(scene);
        stage.show();

    }

// ------------------------------------------------------------------------------- //
    // Cat1 ( switch to cats page > show image > mouse > show info for each cat //
// ------------------------------------------------------------------------------ //
    @FXML
    public void switchToCats_page(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Cats_page.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        home.loadData(username);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);

    }

    @FXML
    void showImage(ActionEvent event) throws MalformedURLException {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List<POJOPet> sList = null;
            String queryStr = "from POJOPet";
            Query query = session.createQuery(queryStr);
            sList = query.list();
            session.close();
            //System.out.println("1");
            int i = 0;

            for (POJOPet pet : sList) {
                new POJOPet(
                        pet.getPetID(),
                        pet.getUserName(),
                        pet.getPet_Image(),
                        pet.getPet_Name(),
                        pet.getPetType(),
                        pet.getBreed(),
                        pet.getPet_Age(),
                        pet.getPet_Gender(),
                        pet.getDescription()
                );

                pe.setPetID(pet.getPetID());
                pe.setUserName(pet.getUserName());
                pe.setPet_Image(pet.getPet_Image());
                pe.setPet_Name(pet.getPet_Name());
                pe.setPetType(pet.getPetType());
                pe.setBreed(pet.getBreed());
                pe.setPet_Age(pet.getPet_Age());
                pe.setPet_Gender(pet.getPet_Gender());
                pe.setDescription(pet.getDescription());

                // show image
                String petImagePath = pe.getPet_Image();
                File petImageFile = new File(petImagePath);
                String petImageUrl = "file:///" + pet.getPet_Image();
                URL imageUrl = new URL(petImageUrl);
                Image petImage1 = new Image(imageUrl.toExternalForm());
                if (i == 3) {
                    CatImage1.setImage(petImage1);
                    CatImage1.setPreserveRatio(true);
                } else if (i == 6) {
                    CatImage2.setImage(petImage1);
                    CatImage2.setPreserveRatio(true);
                }
                i++;
            }

        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void switchToCatInfoMouse(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PetInfo.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        username = UserClass.getUser_Name();
        home.loadData(username);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);

        window.show();

    }

    @FXML
    void ShowInfo(ActionEvent event) throws MalformedURLException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List<POJOPet> sList = null;
            String queryStr = "from POJOPet";
            Query query = session.createQuery(queryStr);
            sList = query.list();
            session.close();

            for (POJOPet pet : sList) {
                new POJOPet(
                        pet.getPetID(),
                        pet.getUserName(),
                        pet.getPet_Image(),
                        pet.getPet_Name(),
                        pet.getPetType(),
                        pet.getBreed(),
                        pet.getPet_Age(),
                        pet.getPet_Gender(),
                        pet.getDescription()
                );

                pe.setPetID(pet.getPetID());
                o = pe.getPetID();
                pe.setUserName(pet.getUserName());
                pe.setPet_Image(pet.getPet_Image());
                pe.setPet_Name(pet.getPet_Name());
                pe.setPetType(pet.getPetType());
                pe.setBreed(pet.getBreed());
                pe.setPet_Age(pet.getPet_Age());
                pe.setPet_Gender(pet.getPet_Gender());
                pe.setDescription(pet.getDescription());
                // show image
                if (pe.getPetType().equals("Cat") && pe.getBreed().equals("baladi")) {
                    String petImagePath = pe.getPet_Image();
                    File petImageFile = new File(petImagePath);
                    String petImageUrl = "file:///" + pe.getPet_Image();
                    URL imageUrl = new URL(petImageUrl);
                    Image petImage1 = new Image(imageUrl.toExternalForm());

                    closePetPhoto.setImage(petImage1);
                    closePetPhoto.setPreserveRatio(true);
                    petname.setText(pe.getPet_Name());
                    petage.setText(Integer.toString(pe.getPet_Age()));
                    petbreed.setText(pe.getBreed());
                    petgender.setText(pe.getPet_Gender());
                    petdescription.setText(pe.getDescription());
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }

    }


    @FXML
    void zoomInDel(MouseEvent event) {
     DelBotton.setOnMouseMoved(event2 -> {
         ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), DelBotton);
         scaleTransition.setToX(1.2);
         scaleTransition.setToY(1.2);
         scaleTransition.play();
     });
    }

    @FXML
    void zoomInShow(MouseEvent event) {
        showButton.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), showButton);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();
        });
    }


    @FXML
    void zoomOutDel(MouseEvent event) {
        DelBotton.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), DelBotton);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
    }

    @FXML
    void zoomOutShow(MouseEvent event) {
        showButton. setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), showButton);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
    }

    // ------------------------------------------------------------------------------- //
    // Cat2 ( switch to cats page > show image ( in the same place of show cat image 1 )  > mouse > show info for each cat //
    // ------------------------------------------------------------------------------ //
    @FXML
    void switchToCatInfoMouse2(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("catInfo2.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        username = UserClass.getUser_Name();
        home.loadData(username);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);

        window.show();

    }

    // cat 2
    @FXML
    void showInfo2(ActionEvent event) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List<POJOPet> sList = null;
            String queryStr = "from POJOPet";
            Query query = session.createQuery(queryStr);
            sList = query.list();
            session.close();

            for (POJOPet pet : sList) {
                new POJOPet(
                        pet.getPetID(),
                        pet.getUserName(),
                        pet.getPet_Image(),
                        pet.getPet_Name(),
                        pet.getPetType(),
                        pet.getBreed(),
                        pet.getPet_Age(),
                        pet.getPet_Gender(),
                        pet.getDescription()
                );

                pe.setPetID(pet.getPetID());
                o = pe.getPetID();
                pe.setUserName(pet.getUserName());
                pe.setPet_Image(pet.getPet_Image());
                pe.setPet_Name(pet.getPet_Name());
                pe.setPetType(pet.getPetType());
                pe.setBreed(pet.getBreed());
                pe.setPet_Age(pet.getPet_Age());
                pe.setPet_Gender(pet.getPet_Gender());
                pe.setDescription(pet.getDescription());
                // show image

                if (pe.getPetType().equals("Cat") && pe.getBreed().equals("ragdoll")) {
                    System.out.println("1");
                    String petImagePath = pe.getPet_Image();
                    File petImageFile = new File(petImagePath);
                    String petImageUrl = "file:///" + pe.getPet_Image();
                    URL imageUrl = new URL(petImageUrl);
                    Image petImage1 = new Image(imageUrl.toExternalForm());

                    catImage2.setImage(petImage1);
                    catImage2.setPreserveRatio(true);
                    Catname.setText(pe.getPet_Name());
                    catAge2.setText(Integer.toString(pe.getPet_Age()));
                    catBreed2.setText(pe.getBreed());
                    catSex2.setText(pe.getPet_Gender());
                    catDiscrepiton2.setText(pe.getDescription());
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }

    }

    // ------------------------------------------------------------------------------- //
    // Dog ( switch to dog page > show image > mouse > show info for a dog //
    // ------------------------------------------------------------------------------ //
    @FXML
    void switchToDogs_page(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Dogs_page.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        home.loadData(username);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);

    }

    @FXML
    void showDogImage(ActionEvent event) throws MalformedURLException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List<POJOPet> sList = null;
            String queryStr = "from POJOPet";
            Query query = session.createQuery(queryStr);
            sList = query.list();
            session.close();
            //System.out.println("1");
            int i = 0;

            for (POJOPet pet : sList) {
                new POJOPet(
                        pet.getPetID(),
                        pet.getUserName(),
                        pet.getPet_Image(),
                        pet.getPet_Name(),
                        pet.getPetType(),
                        pet.getBreed(),
                        pet.getPet_Age(),
                        pet.getPet_Gender(),
                        pet.getDescription()
                );

                pe.setPetID(pet.getPetID());
                pe.setUserName(pet.getUserName());
                pe.setPet_Image(pet.getPet_Image());
                pe.setPet_Name(pet.getPet_Name());
                pe.setPetType(pet.getPetType());
                pe.setBreed(pet.getBreed());
                pe.setPet_Age(pet.getPet_Age());
                pe.setPet_Gender(pet.getPet_Gender());
                pe.setDescription(pet.getDescription());

                // show image
                if (pe.getPetType().equals("Dog")) {
                    String petImagePath = pe.getPet_Image();
                    File petImageFile = new File(petImagePath);
                    String petImageUrl = "file:///" + pet.getPet_Image();
                    URL imageUrl = new URL(petImageUrl);
                    Image petImage1 = new Image(imageUrl.toExternalForm());
                    if (i == 0) {
                        DogImage1.setImage(petImage1);
                        DogImage1.setPreserveRatio(true);
                    }

                    i++;
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void switchToDogInfoMouse(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DogPetInfo.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        home.loadData(username);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);

    }

    @FXML
    void ShowDogInfo(ActionEvent event) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List<POJOPet> sList = null;
            String queryStr = "from POJOPet";
            Query query = session.createQuery(queryStr);
            sList = query.list();
            session.close();

            for (POJOPet pet : sList) {
                new POJOPet(
                        pet.getPetID(),
                        pet.getUserName(),
                        pet.getPet_Image(),
                        pet.getPet_Name(),
                        pet.getPetType(),
                        pet.getBreed(),
                        pet.getPet_Age(),
                        pet.getPet_Gender(),
                        pet.getDescription()
                );

                pe.setPetID(pet.getPetID());
                o = pe.getPetID();
                pe.setUserName(pet.getUserName());
                pe.setPet_Image(pet.getPet_Image());
                pe.setPet_Name(pet.getPet_Name());
                pe.setPetType(pet.getPetType());
                pe.setBreed(pet.getBreed());
                pe.setPet_Age(pet.getPet_Age());
                pe.setPet_Gender(pet.getPet_Gender());
                pe.setDescription(pet.getDescription());
                // show image
                if (pe.getPetType().equals("Dog")) {
                    String petImagePath = pe.getPet_Image();
                    File petImageFile = new File(petImagePath);
                    String petImageUrl = "file:///" + pe.getPet_Image();
                    URL imageUrl = new URL(petImageUrl);
                    Image petImage1 = new Image(imageUrl.toExternalForm());
                    DogPhoto.setImage(petImage1);
                    DogPhoto.setPreserveRatio(true);
                    DogName.setText(pe.getPet_Name());
                    DogAge.setText(Integer.toString(pe.getPet_Age()));
                    DogBreed.setText(pe.getBreed());
                    DogGender.setText(pe.getPet_Gender());
                    DogDescription.setText(pe.getDescription());
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ------------------------------------------------------------------------------- //
    // small pets ( switch to SmallPets page > show image > mouse > show info for a small pet //
    // ------------------------------------------------------------------------------ //
    @FXML
    void switchToSmallPets_page(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SmallPets_page.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        home.loadData(username);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);

    }

    @FXML
    void showSmallPetImage(ActionEvent event) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List<POJOPet> sList = null;
            String queryStr = "from POJOPet";
            Query query = session.createQuery(queryStr);
            sList = query.list();
            session.close();
            //System.out.println("1");
            int i = 0;

            for (POJOPet pet : sList) {
                new POJOPet(
                        pet.getPetID(),
                        pet.getUserName(),
                        pet.getPet_Image(),
                        pet.getPet_Name(),
                        pet.getPetType(),
                        pet.getBreed(),
                        pet.getPet_Age(),
                        pet.getPet_Gender(),
                        pet.getDescription()
                );

                pe.setPetID(pet.getPetID());
                pe.setUserName(pet.getUserName());
                pe.setPet_Image(pet.getPet_Image());
                pe.setPet_Name(pet.getPet_Name());
                pe.setPetType(pet.getPetType());
                pe.setBreed(pet.getBreed());
                pe.setPet_Age(pet.getPet_Age());
                pe.setPet_Gender(pet.getPet_Gender());
                pe.setDescription(pet.getDescription());

                // show image
                if (pe.getPetType().equals("Small Animal")) {
                    String petImagePath = pe.getPet_Image();
                    File petImageFile = new File(petImagePath);
                    String petImageUrl = "file:///" + pet.getPet_Image();
                    URL imageUrl = new URL(petImageUrl);
                    Image petImage1 = new Image(imageUrl.toExternalForm());
                    if (i == 0) {
                        SmallPetImage1.setImage(petImage1);
                        SmallPetImage1.setPreserveRatio(true);
                    }

                    i++;
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void switchToSmallPetInfoMouse(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("smallPetInfo.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        home.loadData(username);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
    }

    @FXML
    void showInforSmallPet(ActionEvent event) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List<POJOPet> sList = null;
            String queryStr = "from POJOPet";
            Query query = session.createQuery(queryStr);
            sList = query.list();
            session.close();

            for (POJOPet pet : sList) {
                new POJOPet(
                        pet.getPetID(),
                        pet.getUserName(),
                        pet.getPet_Image(),
                        pet.getPet_Name(),
                        pet.getPetType(),
                        pet.getBreed(),
                        pet.getPet_Age(),
                        pet.getPet_Gender(),
                        pet.getDescription()
                );

                pe.setPetID(pet.getPetID());
                o = pe.getPetID();
                pe.setUserName(pet.getUserName());
                pe.setPet_Image(pet.getPet_Image());
                pe.setPet_Name(pet.getPet_Name());
                pe.setPetType(pet.getPetType());
                pe.setBreed(pet.getBreed());
                pe.setPet_Age(pet.getPet_Age());
                pe.setPet_Gender(pet.getPet_Gender());
                pe.setDescription(pet.getDescription());
            
            // show image
           
            if (pe.getPetType().equals("Small Animal")) {
                String petImagePath = pe.getPet_Image();
                File petImageFile = new File(petImagePath);
                String petImageUrl = "file:///" + pe.getPet_Image();
                URL imageUrl = new URL(petImageUrl);
                Image petImage1 = new Image(imageUrl.toExternalForm());

                smallPetImage.setImage(petImage1);
                smallPetImage.setPreserveRatio(false);
                Smallpetname.setText(pe.getPet_Name());
                smallPetAge.setText(Integer.toString(pe.getPet_Age()));
                smallPetBreed.setText(pe.getBreed());
                smallPetSex.setText(pe.getPet_Gender());
                smallPetDiscripiton.setText(pe.getDescription());
            }}

        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }

    }

    // ------------------------------------------------------------------------------- //
    // Reptilests_page ( switch to Reptilests_page  > show image > mouse > show info for Reptilest //
    // ------------------------------------------------------------------------------ //
    @FXML
    void switchToReptilests_page(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Reptilests_page.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        home.loadData(username);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);

    }

    @FXML
    void showReptilesImage(ActionEvent event) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List<POJOPet> sList = null;
            String queryStr = "from POJOPet";
            Query query = session.createQuery(queryStr);
            sList = query.list();
            session.close();
            //System.out.println("1");
            int i = 0;

            for (POJOPet pet : sList) {
                new POJOPet(
                        pet.getPetID(),
                        pet.getUserName(),
                        pet.getPet_Image(),
                        pet.getPet_Name(),
                        pet.getPetType(),
                        pet.getBreed(),
                        pet.getPet_Age(),
                        pet.getPet_Gender(),
                        pet.getDescription()
                );

                pe.setPetID(pet.getPetID());
                pe.setUserName(pet.getUserName());
                pe.setPet_Image(pet.getPet_Image());
                pe.setPet_Name(pet.getPet_Name());
                pe.setPetType(pet.getPetType());
                pe.setBreed(pet.getBreed());
                pe.setPet_Age(pet.getPet_Age());
                pe.setPet_Gender(pet.getPet_Gender());
                pe.setDescription(pet.getDescription());

                // show image
                if (pe.getPetType().equals("Reptile")) {
                    String petImagePath = pe.getPet_Image();
                    File petImageFile = new File(petImagePath);
                    String petImageUrl = "file:///" + pet.getPet_Image();
                    URL imageUrl = new URL(petImageUrl);
                    Image petImage1 = new Image(imageUrl.toExternalForm());
                    if (i == 0) {
                        ReptilesImage1.setImage(petImage1);
                        ReptilesImage1.setPreserveRatio(true);
                    }

                    i++;
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @FXML
    void switchToReptilesInfoMouse(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("reptileInfo.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        home.loadData(username);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);

    }

    @FXML
    void showInforReptile(ActionEvent event) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List<POJOPet> sList = null;
            String queryStr = "from POJOPet";
            Query query = session.createQuery(queryStr);
            sList = query.list();
            session.close();
            for (POJOPet pet : sList) {
                new POJOPet(
                        pet.getPetID(),
                        pet.getUserName(),
                        pet.getPet_Image(),
                        pet.getPet_Name(),
                        pet.getPetType(),
                        pet.getBreed(),
                        pet.getPet_Age(),
                        pet.getPet_Gender(),
                        pet.getDescription()
                );

                pe.setPetID(pet.getPetID());
                pe.setUserName(pet.getUserName());
                pe.setPet_Image(pet.getPet_Image());
                pe.setPet_Name(pet.getPet_Name());
                pe.setPetType(pet.getPetType());
                pe.setBreed(pet.getBreed());
                pe.setPet_Age(pet.getPet_Age());
                pe.setPet_Gender(pet.getPet_Gender());
                pe.setDescription(pet.getDescription());

                // show image
                if (pe.getPetType().equals("Reptile")) {
                    String petImagePath = pe.getPet_Image();
                    File petImageFile = new File(petImagePath);
                    String petImageUrl = "file:///" + pe.getPet_Image();
                    URL imageUrl = new URL(petImageUrl);
                    Image petImage1 = new Image(imageUrl.toExternalForm());

                    reptileImage.setImage(petImage1);
                    reptileImage.setPreserveRatio(false);
                    reptileName.setText(pe.getPet_Name());
                    reptileAge.setText(Integer.toString(pe.getPet_Age()));
                    reptileBreed.setText(pe.getBreed());
                    reptileSex.setText(pe.getPet_Gender());
                    reptileDiscription.setText(pe.getDescription());
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }

    }

    // ------------------------------------------------------------------------------ //
    // ------------------------------------------------------------------------------ //
    // clinic home مكرر
    public void changeScreen(ActionEvent event) throws IOException {
        Parent petCareParent = FXMLLoader.load(getClass().getResource("PetCare_page.fxml"));
        Scene petCareScene = new Scene(petCareParent);
        Stage windo = (Stage) ((Node) event.getSource()).getScene().getWindow();

        windo.setScene(petCareScene);
        windo.show();
    }

    // clinic home مكرر
    public void changeScreenToPetCare(ActionEvent event) throws IOException {
        Parent petFoodParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene petFoodScene = new Scene(petFoodParent);
        Stage windo = (Stage) ((Node) event.getSource()).getScene().getWindow();

        windo.setScene(petFoodScene);
        windo.show();
    }

    public void back(ActionEvent event) throws IOException {
        Parent petCare_pageParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene petCare_pageScene = new Scene(petCare_pageParent);
        Stage windo = (Stage) ((Node) event.getSource()).getScene().getWindow();

        windo.setScene(petCare_pageScene);
        windo.show();
    }

    @FXML
    public void AccountInfo_Page(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MyProfile.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        home.loadData(username);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
    }

    public void loadData(String username) {
        this.username = username;
    }

    @FXML
    public void switchToEditProfile(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MyProfile.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        username = UserClass.getUser_Name();
        home.loadData(username);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);

        window.show();

    }

    @FXML
    public void deleteBottonAction(ActionEvent event) throws IOException {

        Alert delete1 = new Alert(AlertType.ERROR);
        delete1.setContentText("Are you sure you want to delete your account?");
        Optional<ButtonType> result = delete1.showAndWait();
        delete1.setTitle("Error Message");
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            String queryst = "from User";
            Query q = session.createQuery(queryst);

            List<User> slist = null;
            slist = q.list();
            session.close();

            user.setUserName(username);
            for (User u : slist) {
                new User(
                        u.getUserName(),
                        u.getFirstName(),
                        u.getLastName(),
                        u.getEmail(),
                        u.getPassword(),
                        u.getPhonoNumber(),
                        u.getCity(),
                        u.getDateOfBirth()
                );

                if (u.getUserName().equals(user.getUserName())) {
                    user.setUserName(u.getUserName());
                    user.setFirstName(u.getFirstName());
                    user.setLastName(u.getLastName());
                    user.setEmail(u.getEmail());
                    user.setPassword(u.getPassword());
                    user.setPhonoNumber(u.getPhonoNumber());
                    user.setCity(u.getCity());
                    user.setDateOfBirth(u.getDateOfBirth());

                    Session Deletesession = HibernateUtil.getSessionFactory().openSession();
                    Deletesession = HibernateUtil.getSessionFactory().openSession();
                    // Transaction Addtx = Deletesession.beginTransaction();
                    Transaction t = null;
                    t = Deletesession.beginTransaction();
                    Deletesession.delete(user);
                    t.commit();
                    System.out.println(user);
                    Deletesession.close();

                    Parent root = FXMLLoader.load(getClass().getResource("first_page.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);// Create a scene and place it in the stage
                    stage.setScene(scene);
                    stage.show();



                }
            }
        }
    }



    public void ShowInformationAction(ActionEvent event) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String queryst = "from User";
        Query q = session.createQuery(queryst);

        List<User> slist = null;
        slist = q.list();
        session.close();

        user.setUserName(username);
        for (User u : slist) {
            new User(
                    u.getUserName(),
                    u.getFirstName(),
                    u.getLastName(),
                    u.getEmail(),
                    u.getPassword(),
                    u.getPhonoNumber(),
                    u.getCity(),
                    u.getDateOfBirth()
            );
            if (u.getUserName().equals(user.getUserName())) {
                user.setUserName(u.getUserName());
                user.setFirstName(u.getFirstName());
                user.setLastName(u.getLastName());
                user.setEmail(u.getEmail());
                user.setPassword(u.getPassword());
                user.setPhonoNumber(u.getPhonoNumber());
                user.setCity(u.getCity());
                user.setDateOfBirth(u.getDateOfBirth());


                 labal1.setText("First Name:");
                firstNameProfile.setText(user.getFirstName());
                labal2.setText("Last Name:");
                lastNameProfile.setText(user.getLastName());
                labal3.setText("User Name:");
                userNameProfile.setText(user.getUserName());
                labal4.setText("Email:");
                emailProfile.setText(user.getEmail());
                phoneNumber.setText("Phone Number:");
                phoneProfile.setText(String.valueOf(user.getPhonoNumber()));
               labal5.setText("Date of Birth:\t");
                birthDateProfile.setText(user.getDateOfBirth().toString());
                labal6.setText("City:");
                cityProfile.setText(user.getCity());
               labal7.setText("Password:");
                passwordProfile.setText(user.getPassword());

            }

        }

    }
    @FXML
    void DeletePet(ActionEvent event) throws IOException {
       /*
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List<POJOPet> sList = null;
            String queryStr = "from POJOPet";
            Query query = session.createQuery(queryStr);
            sList = query.list();
            session.close();
           
            //  pe.setUserName(username);
            //pe.setPetID(petID);
            for (POJOPet pet : sList) {
                new POJOPet(
                        pet.getPetID(),
                        pet.getUserName(),
                        pet.getPet_Image(),
                        pet.getPet_Name(),
                        pet.getPetType(),
                        pet.getBreed(),
                        pet.getPet_Age(),
                        pet.getPet_Gender(),
                        pet.getDescription()
                );
                    System.out.println(pet.getPetID());
                    System.out.println(pe.getPetID());
                   if (pet.getPetID()== pe.getPetID()) {
                      
                    pe.setPetID(pet.getPetID());
                    pe.setUserName(pet.getUserName());
                    pe.setPet_Image(pet.getPet_Image());
                    pe.setPet_Name(pet.getPet_Name());
                    pe.setPetType(pet.getPetType());
                    pe.setBreed(pet.getBreed());
                    pe.setPet_Age(pet.getPet_Age());
                    pe.setPet_Gender(pet.getPet_Gender());
                    pe.setDescription(pet.getDescription());

                    Session Deletesession = HibernateUtil.getSessionFactory().openSession();
                    Deletesession = HibernateUtil.getSessionFactory().openSession();
                    // Transaction Addtx = Deletesession.beginTransaction();
                    Transaction tt = null;
                    tt = Deletesession.beginTransaction();
                    Deletesession.delete(pe);
                    tt.commit();
                    Deletesession.close();

                   // Parent root = FXMLLoader.load(getClass().getResource("first_page.fxml"));
                   // stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   // scene = new Scene(root);// Create a scene and place it in the stage
                   //stage.setScene(scene);
                   // stage.show();

                }
            }*/
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Thanks4Adopting.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        //accsess the controller
        SampleController home = loader.getController();
        home.loadData(username);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);

    }


    // in the pet form
    @FXML
    void openButton(ActionEvent event) throws MalformedURLException {

        FileChooser fileChooser = new FileChooser();

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            // Get the image URL with the file:/ prefix
            String imageUrl = file.toURI().toURL().toExternalForm();

            // Remove the file:/ prefix from the URL
            String formattedImageUrl = imageUrl.substring("file:/".length());

            // Set the formatted image URL to the petImage TextField
            petImage.setText(formattedImageUrl);

        }

    }

    public void switchToThanks(ActionEvent event) throws IOException {

        Session ADDPet = HibernateUtil.getSessionFactory().openSession();
        Transaction Addt = ADDPet.beginTransaction();
        User u = new User();
        // String p=u.setUserName(userName.getText());
        // String p=u.getUserName().toString();
        POJOPet pet = new POJOPet();
        String p = UserClass.getUser_Name();
        // pet.setPetID(Integer.parseInt(this.petIDUser.getText()));
        pet.setPet_Name(this.petNameUser.getText());
        //User.setUserName(this.petIDUser.getText());
        pet.setUserName(p);
        pet.setPet_Image(this.petImage.getText());
        pet.setPetType(this.petTypeUser.getValue());
        pet.setBreed(this.petBreedUser.getText());
        pet.setDescription(this.petDescriptionUser.getText());
        pet.setPet_Age(Integer.parseInt(this.petAgeUser.getText()));
        pet.setPet_Gender(this.male.getText());
        pet.setPet_Gender(this.female.getText());

        ADDPet.save(pet);
        Addt.commit();
        ADDPet.close();

        Parent root = (Parent) FXMLLoader.load(getClass().getResource("Thanks4Adopting.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    // ------------------------------------------------------------------------------------ //
    // mouse & key event //
    // ------------------------------------------------------------------------------------ //
    //Key Event in login textFileds
    @FXML
    void keyLogin(KeyEvent event) {
        loginUserName.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.DOWN) {
                PasswordLoginTextField.requestFocus();;
            }

            PasswordLoginTextField.setOnKeyReleased(e2 -> {
                if (e.getCode() == KeyCode.DOWN) {
                    loginUserName.requestFocus();

                }
            });
        });

    }

    // ------------------------------------------------------------------------------------ //
    // ket event //
    // ------------------------------------------------------------------------------------ //
    //Key Event in signUp textFileds
    @FXML
    private void key(javafx.scene.input.KeyEvent event) throws IOException {

        firstName.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.DOWN) {
                LastName.requestFocus();;
            }
        });

        firstName.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                LastName.requestFocus();;
            }
        });

        LastName.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                LastName.requestFocus();;
            }
        });

        LastName.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                firstName.requestFocus();
            } else if (e.getCode() == KeyCode.LEFT) {
                firstName.requestFocus();
            }
        });

        LastName.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                firstName.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                userName.requestFocus();
            }
        });
        userName.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                LastName.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                userEmail.requestFocus();
            }
        });
        userEmail.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                userName.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                phoneNoTextFiled.requestFocus();
            }
        });
        phoneNoTextFiled.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                userEmail.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                datePokerTextFiled.requestFocus();
            }
        });

        datePokerTextFiled.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                phoneNoTextFiled.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                comboBox.requestFocus();
            }
        });
        comboBox.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                datePokerTextFiled.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                userPassword.requestFocus();
            }
        });
        userPassword.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                comboBox.requestFocus();
            }
        });

    }

    @FXML
    void keyForm(KeyEvent event) {

        petImage.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.DOWN) {
                petNameUser.requestFocus();;
            }
        });

        petNameUser.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                petImage.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                petIDUser.requestFocus();
            }
        });
        petIDUser.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                petTypeUser.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                petBreedUser.requestFocus();
            }
        });

        petBreedUser.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                petTypeUser.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                petAgeUser.requestFocus();
            }
        });
        petAgeUser.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                petBreedUser.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                male.requestFocus();
            }
        });

        male.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                petAgeUser.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                female.requestFocus();
            }
        });
        female.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                male.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                petDescriptionUser.requestFocus();
            }

        });

        petDescriptionUser.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                female.requestFocus();
            } else if (e.getCode() == KeyCode.DOWN) {
                PetFormSubmit.requestFocus();
            }

        });

    }

    // ------------------------------------------------------------------------------------ //
    // mouse event //
    // ------------------------------------------------------------------------------------ //
// zoom in ( PetFormSubmit button )
    @FXML
    void zoomIN(MouseEvent event) {
        PetFormSubmit.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), PetFormSubmit);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();
        });

    }

    // zoom out ( PetFormSubmit button )
    @FXML
    void zoomOut(MouseEvent event) {

        PetFormSubmit.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), PetFormSubmit);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });

    }

    // zooming buttons in the first page
    @FXML
    void ZoomInLoginFirstPage(MouseEvent event) {

        loginBotton1.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), loginBotton1);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();

        });

    }

    @FXML
    void ZoomOutFirstPageLogin(MouseEvent event) {
        loginBotton1.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), loginBotton1);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
    }

    // zooming the sign up button in the first page
    @FXML
    void zoomInFristPage(MouseEvent event) {

        signUpBotton1.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), signUpBotton1);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();

        });

    }

    @FXML
    void zoomOutFirstPage(MouseEvent event) {

        signUpBotton1.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), signUpBotton1);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });

    }

    //Home page zooming
    @FXML
    void zoomInHome1(MouseEvent event) {
        // adopt Now button
        AdoptButtonHomePage.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), AdoptButtonHomePage);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();
        });

    }

    @FXML
    void zoomOutHome1(MouseEvent event) {
// adopt Now button
        AdoptButtonHomePage.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), AdoptButtonHomePage);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
    }

    @FXML
    void zoomInHome2(MouseEvent event) {
// clinic button
        petServiseButton.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), petServiseButton);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();
        });

    }

    @FXML
    void zoomOutHome2(MouseEvent event) {
        // clinic button
        petServiseButton.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), petServiseButton);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
    }

    @FXML
    void zoomInHome3(MouseEvent event) {

        // putAdoption button
        formButton.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), formButton);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();
        });
    }

    @FXML
    void zoomOutHome3(MouseEvent event) {
        // putAdoption button
        formButton.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), formButton);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
    }

    // zooming in sign up page buttons
    @FXML
    void zoomCancelIn(MouseEvent event) {
        cancelButton.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), cancelButton);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();
        });
    }

    @FXML
    void zoomCancelOut(MouseEvent event) {

        cancelButton.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), cancelButton);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
    }

    @FXML
    void zoomInSign2(MouseEvent event) {
        signUpPage.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), signUpPage);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();
        });

    }

    @FXML
    void zoomOutSign2(MouseEvent event) {
        signUpPage.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), signUpPage);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
    }

    // zooming log in buttons
    @FXML
    void zoomCan1In(MouseEvent event) {
        cancelLogin.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), cancelLogin);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();
        });
    }

    @FXML
    void zoomCanlOut(MouseEvent event) {
        cancelLogin.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), cancelLogin);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });

    }

    @FXML
    void zoomInLogin(MouseEvent event) {
        LoginBotton2.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), LoginBotton2);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();
        });
    }

    @FXML
    void zoomOutLogin(MouseEvent event) {
        LoginBotton2.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), LoginBotton2);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
    }

    // clinic page zoom
    @FXML
    void clinicZoomIn(MouseEvent event) {
        clinicButton.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), clinicButton);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();
        });
    }

    @FXML
    void clinicZoomOut(MouseEvent event) {
        clinicButton.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), clinicButton);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
    }

    @FXML
    void consentZoomIn(MouseEvent event) {
        proceedButtonConsent.setOnMouseMoved(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), proceedButtonConsent);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();
        });
    }

    @FXML
    void consentZoomOut(MouseEvent event) {
        proceedButtonConsent.setOnMouseExited(event2 -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(70), proceedButtonConsent);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
    }

    //
    private Media Cat =new Media("https://k.top4top.io/m_27068m99x0.mp3");
    MediaPlayer C = new MediaPlayer(Cat);
    
    private Media Dog =new Media("https://d.top4top.io/m_270660ywg1.mp3");
    MediaPlayer d = new MediaPlayer(Dog);
      
    private Media  smallPet =new Media("https://c.top4top.io/m_2706wx05g1.mp3");
    MediaPlayer s = new MediaPlayer( smallPet);
    
    private Media  reptiles =new Media("https://l.top4top.io/m_2706s6z021.mp3");
    MediaPlayer r = new MediaPlayer( reptiles);
    
    @FXML
    public void smallPetAudio(MouseEvent event) {
        s.play();
    }

    @FXML
    public void catAudio(MouseEvent event) {
         C.play();
    }

    @FXML
    public void dogAudio(MouseEvent event) {
        d.play();
    }

    @FXML
    public void reptilesAudio(MouseEvent event) {
       r.play();
    }

    
    }

   
    
   
 
      


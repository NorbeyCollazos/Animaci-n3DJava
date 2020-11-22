package sample;

import com.javafx.experiments.importers.Importer3D;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{



            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(15), ev -> {
                try {
                    SplashScreen(primaryStage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
            timeline.setCycleCount(1);
            timeline.play();

            Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(15), ev -> {
                try
                {
                    timeline.stop();
                    loadScene3D_Taladro(primaryStage);
                } catch(IOException e)
                {
                    e.printStackTrace();
                }
            }));
            timeline2.setCycleCount(1);
            timeline2.setDelay(Duration.millis(5000));
            timeline2.play();

            Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(15), ev -> {
                try
                {
                    timeline2.stop();
                    loadScene3D_Nevera(primaryStage);
                } catch(IOException e)
                {
                    e.printStackTrace();
                }
            }));
            timeline3.setCycleCount(1);
            timeline3.setDelay(Duration.millis(20000));
            timeline3.play();

            Timeline timeline4 = new Timeline(new KeyFrame(Duration.seconds(15), ev -> {
                try
                {
                    timeline3.stop();
                    loadScene3D_Televisor(primaryStage);
                } catch(IOException e)
                {
                    e.printStackTrace();
                }
            }));
            timeline4.setCycleCount(1);
            timeline4.setDelay(Duration.millis(35000));
            timeline4.play();

            Timeline timeline5 = new Timeline(new KeyFrame(Duration.seconds(15), ev -> {
                try
                {
                    timeline4.stop();
                    loadScene3D_Celular(primaryStage);
                } catch(IOException e)
                {
                    e.printStackTrace();
                }
            }));
            timeline5.setCycleCount(1);
            timeline5.setDelay(Duration.millis(50000));
            timeline5.play();

            Timeline timeline6 = new Timeline(new KeyFrame(Duration.seconds(15), ev -> {
                try
                {
                    timeline5.stop();
                    loadScene3D_Portatil(primaryStage);
                } catch(IOException e)
                {
                    e.printStackTrace();
                }
            }));
            timeline6.setCycleCount(1);
            timeline6.setDelay(Duration.millis(65000));
            timeline6.play();


    }

    private void SplashScreen(Stage stage) throws IOException {
        //Colocamos la imagen de fondo
        ImageView imageView = new ImageView();
        Image bgimage = new Image("sample/fondos/fondo_general.jpg",true);
        imageView.setX(-690.0);
        imageView.setY(-410);
        imageView.setImage(bgimage);
        imageView.setFitHeight(700);
        imageView.setFitWidth(1260);
        imageView.setScaleZ(-300.0);
        imageView.setTranslateZ(120);
        imageView.setFitWidth(0.0);
        imageView.setFitHeight(0.0);

        AmbientLight light1 = new AmbientLight();

        Node techo = Importer3D.load(getClass().getResource("logo/techo.obj").toExternalForm());
        techo.setScaleX(40.0);
        techo.setScaleY(40.0);
        techo.setScaleZ(40.0);
        techo.setTranslateY(-100);

        Node pared1 = Importer3D.load(getClass().getResource("logo/pared1.obj").toExternalForm());
        pared1.setScaleX(40.0);
        pared1.setScaleY(40.0);
        pared1.setScaleZ(40.0);
        pared1.setTranslateX(-45);
        pared1.setTranslateY(-35);

        Node pared2 = Importer3D.load(getClass().getResource("logo/pared2.obj").toExternalForm());
        pared2.setScaleX(40.0);
        pared2.setScaleY(40.0);
        pared2.setScaleZ(40.0);
        pared2.setTranslateX(40);
        pared2.setTranslateY(-40);

        Node chimenea = Importer3D.load(getClass().getResource("logo/chimenea.obj").toExternalForm());
        chimenea.setScaleX(40.0);
        chimenea.setScaleY(40.0);
        chimenea.setScaleZ(40.0);
        chimenea.setTranslateX(-1205);
        chimenea.setTranslateY(-800);

        Node texto = Importer3D.load(getClass().getResource("logo/texto.obj").toExternalForm());
        texto.setScaleX(0.0);
        texto.setScaleY(0.0);
        texto.setScaleZ(0.0);
        texto.setTranslateX(0);
        texto.setTranslateY(80);

        //creamos el group
        Group root = new Group(imageView, techo, pared1, pared2, chimenea, texto, light1);
        //creamos la Escena le agregamos el group y el tamaño de la pantalla
        Scene scene1 = new Scene(root, 1260, 700, true, SceneAntialiasing.BALANCED);

        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateX(scene1.getWidth() / -2.0);
        camera.setTranslateY(scene1.getHeight() / -2.0);

        TranslateTransition p1 = new TranslateTransition(Duration.seconds(2), pared1);
        p1.setFromY(-100.0);
        p1.setToY(-35.0);
        p1.setFromX(-400.0);
        p1.setToX(-45.0);
        p1.play();

        TranslateTransition p2 = new TranslateTransition(Duration.seconds(2), pared2);
        p2.setFromY(-100.0);
        p2.setToY(-40.0);
        p2.setFromX(400.0);
        p2.setToX(40.0);
        p2.play();

        TranslateTransition tec = new TranslateTransition(Duration.seconds(2), techo);
        tec.setFromY(-300.0);
        tec.setToY(-100.0);
        tec.setFromX(0.0);
        tec.setToX(0.0);
        tec.play();

        TranslateTransition chi = new TranslateTransition(Duration.seconds(1), chimenea);
        chi.setFromY(-300.0);
        chi.setToY(-120.0);
        chi.setFromX(-45.0);
        chi.setToX(-45.0);
        chi.setDelay(Duration.millis(1200));
        chi.play();

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2));
        scaleTransition.setFromX(0.0);
        scaleTransition.setToX(90.0);
        scaleTransition.setFromY(0.0);
        scaleTransition.setToY(90.0);

        scaleTransition.setCycleCount(1);
        scaleTransition.setDelay(Duration.millis(2000));
        scaleTransition.play();

        SequentialTransition Transition = new SequentialTransition();
        Transition.getChildren().addAll(scaleTransition);
        Transition.setNode(texto);
        Transition.setCycleCount(1);
        Transition.play();



        scene1.setCamera(camera);
        stage.getIcons().add(new Image("sample/fondos/logo.png"));
        stage.setTitle("HOMECENTER");
        stage.setScene(scene1);
        stage.show();
    }

    private void loadScene3D_Taladro(Stage stage) throws IOException {

        /*creamos un ambiente de luz para uqe
        ilumine toda la escena*/
        AmbientLight light1 = new AmbientLight();

        /*Ahora cargamos el objeto 3D
          y le asignamos el tamaño con las
          propiedades setScale*/
        Node model = Importer3D.load(getClass().getResource("models/taladro12.obj").toExternalForm());
        model.setScaleX(5.0);
        model.setScaleY(5.0);
        model.setScaleZ(5.0);
        model.setTranslateX(-2000);
        model.setTranslateY(-1500);

        //PARA LOS TEXTOS
        Node model_titulo = Importer3D.load(getClass().getResource("titulos/taladro10.obj").toExternalForm());
        model_titulo.setScaleX(50.0);
        model_titulo.setScaleY(50.0);
        model_titulo.setScaleZ(50.0);
        model_titulo.setTranslateX(-2000);
        model_titulo.setTranslateY(-1500);

        Node model_des_1 = Importer3D.load(getClass().getResource("descripciones/taladro_1_1.obj").toExternalForm());
        model_des_1.setScaleX(40.0);
        model_des_1.setScaleY(40.0);
        model_des_1.setScaleZ(40.0);
        model_des_1.setTranslateX(-2000);
        model_des_1.setTranslateY(-1500);

        Node model_des_2 = Importer3D.load(getClass().getResource("descripciones/taladro_2.obj").toExternalForm());
        model_des_2.setScaleX(40.0);
        model_des_2.setScaleY(40.0);
        model_des_2.setScaleZ(40.0);

        Node precio = Importer3D.load(getClass().getResource("precios/precio_antes.obj").toExternalForm());
        precio.setScaleX(40.0);
        precio.setScaleY(40.0);
        precio.setScaleZ(40.0);
        precio.setTranslateX(-2000);
        precio.setTranslateY(-1500);

        Node precio_actual = Importer3D.load(getClass().getResource("precios/precio_despues.obj").toExternalForm());
        precio_actual.setScaleX(40.0);
        precio_actual.setScaleY(40.0);
        precio_actual.setScaleZ(40.0);
        precio_actual.setTranslateX(-2000);
        precio_actual.setTranslateY(-1500);

        Node ahorro = Importer3D.load(getClass().getResource("precios/ahorro_pre.obj").toExternalForm());
        ahorro.setScaleX(40.0);
        ahorro.setScaleY(40.0);
        ahorro.setScaleZ(40.0);
        ahorro.setTranslateX(-2000);
        ahorro.setTranslateY(-1500);

        //PARA EL LOGOTIPO
        Node casa = Importer3D.load(getClass().getResource("logo/casa.obj").toExternalForm());
        casa.setScaleX(12.0);
        casa.setScaleY(12.0);
        casa.setScaleZ(12.0);
        casa.setTranslateX(-540);
        casa.setTranslateY(-300);

        Node texto_logo = Importer3D.load(getClass().getResource("logo/texto_logo.obj").toExternalForm());
        texto_logo.setScaleX(30.0);
        texto_logo.setScaleY(30.0);
        texto_logo.setScaleZ(30.0);
        texto_logo.setTranslateX(-540);
        texto_logo.setTranslateY(-250);
        //animación para el logotipo
        RotateTransition rt_logo = new RotateTransition(Duration.seconds(13), casa);
        rt_logo.setCycleCount(1);
        rt_logo.setFromAngle(0);
        rt_logo.setToAngle(360);
        rt_logo.setAxis(new Point3D(0, 1, 1));
        rt_logo.play();


        //Ahora colocamos la imagen de fondo
        ImageView imageView = new ImageView();
        Image bgimage = new Image("sample/fondos/fondo_general.jpg",true);
        imageView.setX(-690.0);
        imageView.setY(-410);
        imageView.setImage(bgimage);
        imageView.setFitHeight(700);
        imageView.setFitWidth(1260);
        imageView.setScaleZ(-300.0);
        imageView.setTranslateZ(120);
        imageView.setFitWidth(0.0);
        imageView.setFitHeight(0.0);
        //creamos el group
        Group root = new Group(imageView, model, model_titulo, model_des_1, model_des_2, precio, precio_actual, ahorro, casa, texto_logo, light1);
        //creamos la Escena le agregamos el group y el tamaño de la pantalla
        Scene scene1 = new Scene(root, 1260, 700, true, SceneAntialiasing.BALANCED);

        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateX(scene1.getWidth() / -2.0);
        camera.setTranslateY(scene1.getHeight() / -2.0);

        /*Es es un efecto Traslate de entrada el cual va a
          desplazar el objeto desde la ezquina superior izquierda
          hasta el centro de la pantalla*/
        TranslateTransition tra = new TranslateTransition(Duration.seconds(3), model);
        tra.setFromY(-300.0);
        tra.setToY(0.0);
        tra.setFromX(-700.0);
        tra.setToX(-50.0);
        tra.play();

        /*Este es un efecto de escala para hacer que la
          imagen se agrande*/
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(7));
        scaleTransition.setFromX(100.0);
        scaleTransition.setToX(190.0);
        scaleTransition.setFromY(100.0);
        scaleTransition.setToY(190.0);

        scaleTransition.setCycleCount(1);
        scaleTransition.play();

        SequentialTransition Transition = new SequentialTransition();
        Transition.getChildren().addAll(scaleTransition);
        Transition.setNode(model);
        Transition.setCycleCount(1);
        Transition.play();
        //animación de salida para el taladro
        TranslateTransition tra_salida = new TranslateTransition(Duration.seconds(2), model);
        tra_salida.setFromY(0.0);
        tra_salida.setToY(-300.0);
        tra_salida.setFromX(-50.0);
        tra_salida.setToX(-1200.0);
        tra_salida.setDelay(Duration.millis(12500));
        tra_salida.play();

        //animación del título
        TranslateTransition tr = new TranslateTransition(Duration.seconds(2), model_titulo);
        tr.setFromY(-650.0);
        tr.setToY(-300.0);
        tr.setFromX(0.0);
        tr.setToX(0.0);
        tr.play();
        //animacion de salida para el título
        TranslateTransition tr_salida = new TranslateTransition(Duration.seconds(2), model_titulo);
        tr_salida.setFromY(-300.0);
        tr_salida.setToY(-650.0);
        tr_salida.setFromX(0.0);
        tr_salida.setToX(0.0);
        tr_salida.setDelay(Duration.millis(12500));
        tr_salida.play();

        //animación de la primera descripción
        TranslateTransition d1 = new TranslateTransition(Duration.seconds(2), model_des_1);
        d1.setFromY(0.0);
        d1.setToY(0.0);
        d1.setFromX(-600.0);
        d1.setToX(-400.0);
        d1.play();
        //animación de salida primera descripción
        TranslateTransition d1_salida = new TranslateTransition(Duration.seconds(2), model_des_1);
        d1_salida.setFromY(0.0);
        d1_salida.setToY(0.0);
        d1_salida.setFromX(-400.0);
        d1_salida.setToX(-1000.0);
        d1_salida.setDelay(Duration.millis(12500));
        d1_salida.play();

        //animación para la segunda descripción
        TranslateTransition d2 = new TranslateTransition(Duration.seconds(2), model_des_2);
        d2.setFromY(100.0);
        d2.setToY(100.0);
        d2.setFromX(600.0);
        d2.setToX(400.0);
        d2.play();
        //aniimación de salida segunda descripción
        TranslateTransition d2_salida = new TranslateTransition(Duration.seconds(2), model_des_2);
        d2_salida.setFromY(100.0);
        d2_salida.setToY(100.0);
        d2_salida.setFromX(400.0);
        d2_salida.setToX(10000.0);
        d2_salida.setDelay(Duration.millis(12500));
        d2_salida.play();

        //animación para el precio anterior
        TranslateTransition precio_t = new TranslateTransition(Duration.seconds(2), precio);
        precio_t.setFromY(400.0);
        precio_t.setToY(200.0);
        precio_t.setFromX(0.0);
        precio_t.setToX(0.0);
        precio_t.play();
        //animación de salida precio anterior
        TranslateTransition precio_t_salida = new TranslateTransition(Duration.seconds(2), precio);
        precio_t_salida.setFromY(200.0);
        precio_t_salida.setToY(600.0);
        precio_t_salida.setFromX(0.0);
        precio_t_salida.setToX(0.0);
        precio_t_salida.setDelay(Duration.millis(12500));
        precio_t_salida.play();

        //animación para el precio actual
        TranslateTransition precio_ta = new TranslateTransition(Duration.seconds(2), precio_actual);
        precio_ta.setFromY(400.0);
        precio_ta.setToY(240.0);
        precio_ta.setFromX(0.0);
        precio_ta.setToX(0.0);
        precio_ta.play();
        //animación de salida precio actual
        TranslateTransition precio_ta_salida = new TranslateTransition(Duration.seconds(2), precio_actual);
        precio_ta_salida.setFromY(2400.0);
        precio_ta_salida.setToY(600.0);
        precio_ta_salida.setFromX(0.0);
        precio_ta_salida.setToX(0.0);
        precio_ta_salida.setDelay(Duration.millis(12500));
        precio_ta_salida.play();

        //animación para oferta
        TranslateTransition precio_ahorro = new TranslateTransition(Duration.seconds(2), ahorro);
        precio_ahorro.setFromY(400.0);
        precio_ahorro.setToY(290.0);
        precio_ahorro.setFromX(0.0);
        precio_ahorro.setToX(0.0);
        precio_ahorro.play();
        //animacion de escala para oferta
        ScaleTransition scaleTransition_promo = new ScaleTransition(Duration.seconds(2));
        scaleTransition_promo.setFromX(40.0);
        scaleTransition_promo.setToX(50.0);
        scaleTransition_promo.setFromY(40.0);
        scaleTransition_promo.setToY(50.0);
        scaleTransition_promo.setCycleCount(2);
        scaleTransition_promo.setAutoReverse(true);
        SequentialTransition Transition_pro = new SequentialTransition();
        Transition_pro.getChildren().addAll(scaleTransition_promo);
        Transition_pro.setNode(ahorro);
        Transition_pro.setCycleCount(PathTransition.INDEFINITE);
        Transition_pro.play();
        //animación de salida para la oferta
        TranslateTransition precio_ahorro_salida = new TranslateTransition(Duration.seconds(2), ahorro);
        precio_ahorro_salida.setFromY(290.0);
        precio_ahorro_salida.setToY(600.0);
        precio_ahorro_salida.setFromX(0.0);
        precio_ahorro_salida.setToX(0.0);
        precio_ahorro_salida.setDelay(Duration.millis(12500));
        precio_ahorro_salida.play();



        scene1.setCamera(camera);
        stage.setTitle("Taladro Pecutor");
        stage.setScene(scene1);
        stage.show();
    }

    private void loadScene3D_Nevera(Stage stage) throws IOException {

        AmbientLight light1 = new AmbientLight();

        Node model = Importer3D.load(getClass().getResource("models/nevera.obj").toExternalForm());
        model.setScaleX(150.0);
        model.setScaleY(150.0);
        model.setScaleZ(150.0);
        model.setTranslateY(800);
        model.setTranslateX(-800);

        //PARA LOS TEXTOS
        Node model_titulo = Importer3D.load(getClass().getResource("titulos/nevera.obj").toExternalForm());
        model_titulo.setScaleX(50.0);
        model_titulo.setScaleY(50.0);
        model_titulo.setScaleZ(50.0);
        model_titulo.setTranslateX(-2000);
        model_titulo.setTranslateY(-1500);

        Node model_des_1 = Importer3D.load(getClass().getResource("descripciones/nevera_1.obj").toExternalForm());
        model_des_1.setScaleX(40.0);
        model_des_1.setScaleY(40.0);
        model_des_1.setScaleZ(40.0);
        model_des_1.setTranslateX(-2000);
        model_des_1.setTranslateY(-1500);

        Node model_des_2 = Importer3D.load(getClass().getResource("descripciones/nevera_2.obj").toExternalForm());
        model_des_2.setScaleX(40.0);
        model_des_2.setScaleY(40.0);
        model_des_2.setScaleZ(40.0);
        model_des_2.setTranslateX(-2000);
        model_des_2.setTranslateY(-1500);

        Node model_des_3 = Importer3D.load(getClass().getResource("descripciones/nevera_3.obj").toExternalForm());
        model_des_3.setScaleX(40.0);
        model_des_3.setScaleY(40.0);
        model_des_3.setScaleZ(40.0);
        model_des_3.setTranslateX(-2000);
        model_des_3.setTranslateY(-1500);

        Node precio = Importer3D.load(getClass().getResource("precios/precio_antes.obj").toExternalForm());
        precio.setScaleX(40.0);
        precio.setScaleY(40.0);
        precio.setScaleZ(40.0);
        precio.setTranslateX(-2000);
        precio.setTranslateY(-1500);

        Node precio_actual = Importer3D.load(getClass().getResource("precios/precio_despues.obj").toExternalForm());
        precio_actual.setScaleX(40.0);
        precio_actual.setScaleY(40.0);
        precio_actual.setScaleZ(40.0);
        precio_actual.setTranslateX(-2000);
        precio_actual.setTranslateY(-1500);

        Node ahorro = Importer3D.load(getClass().getResource("precios/ahorro_pre.obj").toExternalForm());
        ahorro.setScaleX(40.0);
        ahorro.setScaleY(40.0);
        ahorro.setScaleZ(40.0);
        ahorro.setTranslateX(-2000);
        ahorro.setTranslateY(-1500);

        //PARA EL LOGOTIPO
        Node casa = Importer3D.load(getClass().getResource("logo/casa.obj").toExternalForm());
        casa.setScaleX(12.0);
        casa.setScaleY(12.0);
        casa.setScaleZ(12.0);
        casa.setTranslateX(-540);
        casa.setTranslateY(-300);

        Node texto_logo = Importer3D.load(getClass().getResource("logo/texto_logo.obj").toExternalForm());
        texto_logo.setScaleX(30.0);
        texto_logo.setScaleY(30.0);
        texto_logo.setScaleZ(30.0);
        texto_logo.setTranslateX(-540);
        texto_logo.setTranslateY(-250);
        //animación para el logotipo
        RotateTransition rt_logo = new RotateTransition(Duration.seconds(13), casa);
        rt_logo.setCycleCount(1);
        rt_logo.setFromAngle(0);
        rt_logo.setToAngle(360);
        rt_logo.setAxis(new Point3D(0, 1, 1));
        rt_logo.play();

        ImageView imageView = new ImageView();
        Image bgimage = new Image("sample/fondos/fondo_general.jpg",true);
        imageView.setX(-690.0);
        imageView.setY(-410);
        imageView.setImage(bgimage);
        imageView.setFitHeight(700);
        imageView.setFitWidth(1260);
        imageView.setScaleZ(-300.0);
        imageView.setTranslateZ(120);
        imageView.setFitWidth(0.0);
        imageView.setFitHeight(0.0);

        Group root = new Group(imageView, model, model_titulo, model_des_1, model_des_2, model_des_3, precio, precio_actual, ahorro, casa, texto_logo, light1);

        Scene scene1 = new Scene(root, 1260, 700, true, SceneAntialiasing.BALANCED);

        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateX(scene1.getWidth() / -2.0);
        camera.setTranslateY(scene1.getHeight() / -2.0);


        /*Efecto que traslada el objeto desla esquina inferior
         izquierda hasta la parte izquierda de la pantalla*/
        TranslateTransition tran = new TranslateTransition(Duration.seconds(2), model);
        tran.setFromY(450.0);
        tran.setToY(80.0);
        tran.setFromX(-800.0);
        tran.setToX(-400.0);
        tran.play();
        //animación de rotación sobre el eje y
        RotateTransition rt = new RotateTransition(Duration.seconds(10), model);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setAxis(new Point3D(0, 1, 0));
        rt.play();
        //Para hacer el efecto de salida
        TranslateTransition tran_salida = new TranslateTransition(Duration.seconds(2), model);
        tran_salida.setFromY(80.0);
        tran_salida.setToY(450.0);
        tran_salida.setFromX(-400.0);
        tran_salida.setToX(-1000.0);
        tran_salida.setDelay(Duration.millis(13000));
        tran_salida.play();


        //ANIMACIONES DE TEXTOS
        //Animación de título
        TranslateTransition tr = new TranslateTransition(Duration.seconds(2), model_titulo);
        tr.setFromY(-650.0);
        tr.setToY(-300.0);
        tr.setFromX(250.0);
        tr.setToX(250.0);
        tr.play();
        //Animación de salida
        TranslateTransition tr_salida = new TranslateTransition(Duration.seconds(2), model_titulo);
        tr_salida.setFromY(-300.0);
        tr_salida.setToY(-650.0);
        tr_salida.setFromX(250.0);
        tr_salida.setToX(250.0);
        tr_salida.setDelay(Duration.millis(13000));
        tr_salida.play();

        //Animación de la primera descripción
        TranslateTransition d1 = new TranslateTransition(Duration.seconds(2), model_des_1);
        d1.setFromY(-180.0);
        d1.setToY(-180.0);
        d1.setFromX(600.0);
        d1.setToX(200.0);
        d1.play();
        //Animación de salida
        TranslateTransition d1_salida = new TranslateTransition(Duration.seconds(2), model_des_1);
        d1_salida.setFromY(-180.0);
        d1_salida.setToY(-180.0);
        d1_salida.setFromX(200.0);
        d1_salida.setToX(1300.0);
        d1_salida.setDelay(Duration.millis(13000));
        d1_salida.play();

        //Animación de la segunda descripción
        TranslateTransition d2 = new TranslateTransition(Duration.seconds(2), model_des_2);
        d2.setFromY(-50.0);
        d2.setToY(-50.0);
        d2.setFromX(-600.0);
        d2.setToX(200.0);
        d2.play();
        //Animación de salida
        TranslateTransition d2_salida = new TranslateTransition(Duration.seconds(2), model_des_2);
        d2_salida.setFromY(-50.0);
        d2_salida.setToY(-50.0);
        d2_salida.setFromX(200.0);
        d2_salida.setToX(-1300.0);
        d2_salida.setDelay(Duration.millis(13000));
        d2_salida.play();

        //Animación de la tercera descripción
        TranslateTransition d3 = new TranslateTransition(Duration.seconds(2), model_des_3);
        d3.setFromY(600.0);
        d3.setToY(80.0);
        d3.setFromX(200.0);
        d3.setToX(200.0);
        d3.play();
        //Animación de salida
        TranslateTransition d3_salida = new TranslateTransition(Duration.seconds(2), model_des_3);
        d3_salida.setFromY(80.0);
        d3_salida.setToY(1000.0);
        d3_salida.setFromX(200.0);
        d3_salida.setToX(200.0);
        d3_salida.setDelay(Duration.millis(13000));
        d3_salida.play();

        //animación para el precio anterior
        TranslateTransition precio_t = new TranslateTransition(Duration.seconds(2), precio);
        precio_t.setFromY(400.0);
        precio_t.setToY(200.0);
        precio_t.setFromX(0.0);
        precio_t.setToX(0.0);
        precio_t.play();
        //animación de salida precio anterior
        TranslateTransition precio_t_salida = new TranslateTransition(Duration.seconds(2), precio);
        precio_t_salida.setFromY(200.0);
        precio_t_salida.setToY(600.0);
        precio_t_salida.setFromX(0.0);
        precio_t_salida.setToX(0.0);
        precio_t_salida.setDelay(Duration.millis(13000));
        precio_t_salida.play();

        //animación para el precio actual
        TranslateTransition precio_ta = new TranslateTransition(Duration.seconds(2), precio_actual);
        precio_ta.setFromY(400.0);
        precio_ta.setToY(240.0);
        precio_ta.setFromX(0.0);
        precio_ta.setToX(0.0);
        precio_ta.play();
        //animación de salida precio actual
        TranslateTransition precio_ta_salida = new TranslateTransition(Duration.seconds(2), precio_actual);
        precio_ta_salida.setFromY(2400.0);
        precio_ta_salida.setToY(600.0);
        precio_ta_salida.setFromX(0.0);
        precio_ta_salida.setToX(0.0);
        precio_ta_salida.setDelay(Duration.millis(13000));
        precio_ta_salida.play();

        //animación para oferta
        TranslateTransition precio_ahorro = new TranslateTransition(Duration.seconds(2), ahorro);
        precio_ahorro.setFromY(400.0);
        precio_ahorro.setToY(290.0);
        precio_ahorro.setFromX(0.0);
        precio_ahorro.setToX(0.0);
        precio_ahorro.play();

        //animacion de escala para oferta
        ScaleTransition scaleTransition_promo = new ScaleTransition(Duration.seconds(2));
        scaleTransition_promo.setFromX(40.0);
        scaleTransition_promo.setToX(50.0);
        scaleTransition_promo.setFromY(40.0);
        scaleTransition_promo.setToY(50.0);
        // Let the animation run forever
        scaleTransition_promo.setCycleCount(2);
        // Reverse direction on alternating cycles
        scaleTransition_promo.setAutoReverse(true);

        SequentialTransition Transition_pro = new SequentialTransition();
        Transition_pro.getChildren().addAll(scaleTransition_promo);
        Transition_pro.setNode(ahorro);
        Transition_pro.setCycleCount(PathTransition.INDEFINITE);
        Transition_pro.play();
        //animación de salida para la oferta
        TranslateTransition precio_ahorro_salida = new TranslateTransition(Duration.seconds(2), ahorro);
        precio_ahorro_salida.setFromY(290.0);
        precio_ahorro_salida.setToY(600.0);
        precio_ahorro_salida.setFromX(0.0);
        precio_ahorro_salida.setToX(0.0);
        precio_ahorro_salida.setDelay(Duration.millis(13000));
        precio_ahorro_salida.play();



        scene1.setFill(Color.WHITE);
        scene1.setCamera(camera);
        stage.setTitle("Nevera");
        stage.setScene(scene1);
        stage.show();
    }


    private void loadScene3D_Televisor(Stage stage) throws IOException {

        AmbientLight light1 = new AmbientLight();

        Node model = Importer3D.load(getClass().getResource("models/televisor17.obj").toExternalForm());
        model.setScaleX(30.0);
        model.setScaleY(30.0);
        model.setScaleZ(30.0);
        model.setTranslateY(800);
        model.setTranslateX(-800);

        //PARA LOS TEXTOS
        Node model_titulo = Importer3D.load(getClass().getResource("titulos/televisor.obj").toExternalForm());
        model_titulo.setScaleX(50.0);
        model_titulo.setScaleY(50.0);
        model_titulo.setScaleZ(50.0);
        model_titulo.setTranslateX(-2000);
        model_titulo.setTranslateY(-1500);

        Node model_des_1 = Importer3D.load(getClass().getResource("descripciones/televisor.obj").toExternalForm());
        model_des_1.setScaleX(30.0);
        model_des_1.setScaleY(30.0);
        model_des_1.setScaleZ(30.0);
        model_des_1.setTranslateX(-2000);
        model_des_1.setTranslateY(-1500);

        Node model_des_2 = Importer3D.load(getClass().getResource("descripciones/televisor1.obj").toExternalForm());
        model_des_2.setScaleX(30.0);
        model_des_2.setScaleY(30.0);
        model_des_2.setScaleZ(30.0);
        model_des_2.setTranslateX(-2000);
        model_des_2.setTranslateY(-1500);


        Node precio = Importer3D.load(getClass().getResource("precios/precio_antes.obj").toExternalForm());
        precio.setScaleX(40.0);
        precio.setScaleY(40.0);
        precio.setScaleZ(40.0);
        precio.setTranslateX(-2000);
        precio.setTranslateY(-1500);

        Node precio_actual = Importer3D.load(getClass().getResource("precios/precio_despues.obj").toExternalForm());
        precio_actual.setScaleX(40.0);
        precio_actual.setScaleY(40.0);
        precio_actual.setScaleZ(40.0);
        precio_actual.setTranslateX(-2000);
        precio_actual.setTranslateY(-1500);

        Node ahorro = Importer3D.load(getClass().getResource("precios/ahorro_pre.obj").toExternalForm());
        ahorro.setScaleX(40.0);
        ahorro.setScaleY(40.0);
        ahorro.setScaleZ(40.0);
        ahorro.setTranslateX(-2000);
        ahorro.setTranslateY(-1500);

        //PARA EL LOGOTIPO
        Node casa = Importer3D.load(getClass().getResource("logo/casa.obj").toExternalForm());
        casa.setScaleX(12.0);
        casa.setScaleY(12.0);
        casa.setScaleZ(12.0);
        casa.setTranslateX(-540);
        casa.setTranslateY(-300);

        Node texto_logo = Importer3D.load(getClass().getResource("logo/texto_logo.obj").toExternalForm());
        texto_logo.setScaleX(30.0);
        texto_logo.setScaleY(30.0);
        texto_logo.setScaleZ(30.0);
        texto_logo.setTranslateX(-540);
        texto_logo.setTranslateY(-250);
        //animación para el logotipo
        RotateTransition rt_logo = new RotateTransition(Duration.seconds(13), casa);
        rt_logo.setCycleCount(1);
        rt_logo.setFromAngle(0);
        rt_logo.setToAngle(360);
        rt_logo.setAxis(new Point3D(0, 1, 1));
        rt_logo.play();

        ImageView imageView = new ImageView();
        Image bgimage = new Image("sample/fondos/fondo_general.jpg",true);
        imageView.setX(-690.0);
        imageView.setY(-410);
        imageView.setImage(bgimage);
        imageView.setFitHeight(700);
        imageView.setFitWidth(1260);
        imageView.setScaleZ(-300.0);
        imageView.setTranslateZ(120);
        imageView.setFitWidth(0.0);
        imageView.setFitHeight(0.0);

        Group root = new Group(imageView, model, model_titulo, model_des_1, model_des_2, precio, precio_actual, ahorro, casa, texto_logo, light1);

        Scene scene1 = new Scene(root, 1260, 700, true, SceneAntialiasing.BALANCED);

        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateX(scene1.getWidth() / -2.0);
        camera.setTranslateY(scene1.getHeight() / -2.0);


        /*con este efecto el objeto hace un recorrido desde la
          parte izquierda de la pantalla hacia la parte derecha*/
        TranslateTransition tran = new TranslateTransition(Duration.seconds(5), model);
        tran.setFromY(-90.0);
        tran.setToY(-90.0);
        tran.setFromX(-400.0);
        tran.setToX(400.0);
        tran.play();
        /*Cuando el objeto se encuentra en la parte derecha
          hacemos que se traslade hacia el centro de la pantalla*/
        TranslateTransition tran2 = new TranslateTransition(Duration.seconds(3), model);
        tran2.setFromY(-90.0);
        tran2.setToY(-90.0);
        tran2.setFromX(400.0);
        tran2.setToX(0.0);
        tran2.setDelay(Duration.millis(5000));
        tran2.play();

        //Ahora hacemos que tenga un efecto de zoom
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(3));
        scaleTransition.setFromX(30.0);
        scaleTransition.setToX(40.0);
        scaleTransition.setFromY(30.0);
        scaleTransition.setToY(40.0);
        // Let the animation run forever
        scaleTransition.setCycleCount(1);
        // Reverse direction on alternating cycles
        scaleTransition.setAutoReverse(true);

        SequentialTransition Transition = new SequentialTransition();
        Transition.getChildren().addAll(scaleTransition);
        Transition.setNode(model);
        Transition.setCycleCount(1);
        Transition.setDelay(Duration.millis(8000));
        Transition.play();

        //Efecto de salida
        ScaleTransition scaleTransition_salida = new ScaleTransition(Duration.seconds(2));
        scaleTransition_salida.setFromX(30.0);
        scaleTransition_salida.setToX(0.0);
        scaleTransition_salida.setFromY(30.0);
        scaleTransition_salida.setToY(0.0);
        // Let the animation run forever
        scaleTransition_salida.setCycleCount(1);
        // Reverse direction on alternating cycles
        scaleTransition_salida.setAutoReverse(true);

        SequentialTransition Transition_salida = new SequentialTransition();
        Transition_salida.getChildren().addAll(scaleTransition_salida);
        Transition_salida.setNode(model);
        Transition_salida.setCycleCount(1);
        Transition_salida.setDelay(Duration.millis(12500));
        Transition_salida.play();

        //animaciones de textos
        //Animación del título
        TranslateTransition tr = new TranslateTransition(Duration.seconds(2), model_titulo);
        tr.setFromY(-650.0);
        tr.setToY(-300.0);
        tr.setFromX(0.0);
        tr.setToX(0.0);
        tr.play();
        //animación de salida
        TranslateTransition tr_salida = new TranslateTransition(Duration.seconds(2), model_titulo);
        tr_salida.setFromY(-300.0);
        tr_salida.setToY(-700.0);
        tr_salida.setFromX(0.0);
        tr_salida.setToX(0.0);
        tr_salida.setDelay(Duration.millis(12500));
        tr_salida.play();

        //Animación de la primera descripción
        TranslateTransition d1 = new TranslateTransition(Duration.seconds(2), model_des_1);
        d1.setFromY(600.0);
        d1.setToY(0.0);
        d1.setFromX(-400.0);
        d1.setToX(-400.0);
        d1.play();
        //Animación de salida
        TranslateTransition d1_salida = new TranslateTransition(Duration.seconds(2), model_des_1);
        d1_salida.setFromY(0.0);
        d1_salida.setToY(600.0);
        d1_salida.setFromX(-400.0);
        d1_salida.setToX(-400.0);
        d1_salida.setDelay(Duration.millis(12500));
        d1_salida.play();

        //Animación para la segunda descripción
        TranslateTransition d2 = new TranslateTransition(Duration.seconds(8), model_des_2);
        d2.setFromY(600.0);
        d2.setToY(0.0);
        d2.setFromX(400.0);
        d2.setToX(400.0);
        d2.play();
        //Animación de salida
        TranslateTransition d2_salida = new TranslateTransition(Duration.seconds(2), model_des_2);
        d2_salida.setFromY(0.0);
        d2_salida.setToY(600.0);
        d2_salida.setFromX(400.0);
        d2_salida.setToX(400.0);
        d2_salida.setDelay(Duration.millis(12500));
        d2_salida.play();


        //animación para el precio anterior
        TranslateTransition precio_t = new TranslateTransition(Duration.seconds(2), precio);
        precio_t.setFromY(400.0);
        precio_t.setToY(200.0);
        precio_t.setFromX(0.0);
        precio_t.setToX(0.0);
        precio_t.play();
        //animación de salida precio anterior
        TranslateTransition precio_t_salida = new TranslateTransition(Duration.seconds(2), precio);
        precio_t_salida.setFromY(200.0);
        precio_t_salida.setToY(600.0);
        precio_t_salida.setFromX(0.0);
        precio_t_salida.setToX(0.0);
        precio_t_salida.setDelay(Duration.millis(12500));
        precio_t_salida.play();

        //animación para el precio actual
        TranslateTransition precio_ta = new TranslateTransition(Duration.seconds(2), precio_actual);
        precio_ta.setFromY(400.0);
        precio_ta.setToY(240.0);
        precio_ta.setFromX(0.0);
        precio_ta.setToX(0.0);
        precio_ta.play();
        //animación de salida precio actual
        TranslateTransition precio_ta_salida = new TranslateTransition(Duration.seconds(2), precio_actual);
        precio_ta_salida.setFromY(2400.0);
        precio_ta_salida.setToY(600.0);
        precio_ta_salida.setFromX(0.0);
        precio_ta_salida.setToX(0.0);
        precio_ta_salida.setDelay(Duration.millis(12500));
        precio_ta_salida.play();

        //animación para oferta
        TranslateTransition precio_ahorro = new TranslateTransition(Duration.seconds(2), ahorro);
        precio_ahorro.setFromY(400.0);
        precio_ahorro.setToY(290.0);
        precio_ahorro.setFromX(0.0);
        precio_ahorro.setToX(0.0);
        precio_ahorro.play();

        //animacion de escala para oferta
        ScaleTransition scaleTransition_promo = new ScaleTransition(Duration.seconds(2));
        scaleTransition_promo.setFromX(40.0);
        scaleTransition_promo.setToX(50.0);
        scaleTransition_promo.setFromY(40.0);
        scaleTransition_promo.setToY(50.0);
        // Let the animation run forever
        scaleTransition_promo.setCycleCount(2);
        // Reverse direction on alternating cycles
        scaleTransition_promo.setAutoReverse(true);

        SequentialTransition Transition_pro = new SequentialTransition();
        Transition_pro.getChildren().addAll(scaleTransition_promo);
        Transition_pro.setNode(ahorro);
        Transition_pro.setCycleCount(PathTransition.INDEFINITE);
        Transition_pro.play();
        //animación de salida para la oferta
        TranslateTransition precio_ahorro_salida = new TranslateTransition(Duration.seconds(2), ahorro);
        precio_ahorro_salida.setFromY(290.0);
        precio_ahorro_salida.setToY(600.0);
        precio_ahorro_salida.setFromX(0.0);
        precio_ahorro_salida.setToX(0.0);
        precio_ahorro_salida.setDelay(Duration.millis(12500));
        precio_ahorro_salida.play();

        scene1.setFill(Color.WHITE);
        scene1.setCamera(camera);
        stage.setTitle("Televisor");
        stage.setScene(scene1);
        stage.show();
    }


    private void loadScene3D_Celular(Stage stage) throws IOException {

        AmbientLight light1 = new AmbientLight();

        Node model = Importer3D.load(getClass().getResource("models/celular4.obj").toExternalForm());
        model.setScaleX(90.0);
        model.setScaleY(90.0);
        model.setScaleZ(90.0);
        model.setTranslateY(800);
        model.setTranslateX(-800);


        //PARA LOS TEXTOS
        Node model_titulo = Importer3D.load(getClass().getResource("titulos/celular.obj").toExternalForm());
        model_titulo.setScaleX(50.0);
        model_titulo.setScaleY(50.0);
        model_titulo.setScaleZ(50.0);
        model_titulo.setTranslateX(-2000);
        model_titulo.setTranslateY(-1500);

        Node model_des_1 = Importer3D.load(getClass().getResource("descripciones/celular.obj").toExternalForm());
        model_des_1.setScaleX(30.0);
        model_des_1.setScaleY(30.0);
        model_des_1.setScaleZ(30.0);
        model_des_1.setTranslateX(-2000);
        model_des_1.setTranslateY(-1500);

        Node model_des_2 = Importer3D.load(getClass().getResource("descripciones/celular1.obj").toExternalForm());
        model_des_2.setScaleX(30.0);
        model_des_2.setScaleY(30.0);
        model_des_2.setScaleZ(30.0);
        model_des_2.setTranslateX(-2000);
        model_des_2.setTranslateY(-1500);


        Node precio = Importer3D.load(getClass().getResource("precios/precio_antes.obj").toExternalForm());
        precio.setScaleX(40.0);
        precio.setScaleY(40.0);
        precio.setScaleZ(40.0);
        precio.setTranslateX(-2000);
        precio.setTranslateY(-1500);

        Node precio_actual = Importer3D.load(getClass().getResource("precios/precio_despues.obj").toExternalForm());
        precio_actual.setScaleX(40.0);
        precio_actual.setScaleY(40.0);
        precio_actual.setScaleZ(40.0);
        precio_actual.setTranslateX(-2000);
        precio_actual.setTranslateY(-1500);

        Node ahorro = Importer3D.load(getClass().getResource("precios/ahorro_pre.obj").toExternalForm());
        ahorro.setScaleX(40.0);
        ahorro.setScaleY(40.0);
        ahorro.setScaleZ(40.0);
        ahorro.setTranslateX(-2000);
        ahorro.setTranslateY(-1500);

        //PARA EL LOGOTIPO
        Node casa = Importer3D.load(getClass().getResource("logo/casa.obj").toExternalForm());
        casa.setScaleX(12.0);
        casa.setScaleY(12.0);
        casa.setScaleZ(12.0);
        casa.setTranslateX(-540);
        casa.setTranslateY(-300);

        Node texto_logo = Importer3D.load(getClass().getResource("logo/texto_logo.obj").toExternalForm());
        texto_logo.setScaleX(30.0);
        texto_logo.setScaleY(30.0);
        texto_logo.setScaleZ(30.0);
        texto_logo.setTranslateX(-540);
        texto_logo.setTranslateY(-250);
        //animación para el logotipo
        RotateTransition rt_logo = new RotateTransition(Duration.seconds(13), casa);
        rt_logo.setCycleCount(1);
        rt_logo.setFromAngle(0);
        rt_logo.setToAngle(360);
        rt_logo.setAxis(new Point3D(0, 1, 1));
        rt_logo.play();

        ImageView imageView = new ImageView();
        Image bgimage = new Image("sample/fondos/fondo_general.jpg",true);
        imageView.setX(-690.0);
        imageView.setY(-410);
        imageView.setImage(bgimage);
        imageView.setFitHeight(700);
        imageView.setFitWidth(1260);
        imageView.setScaleZ(-300.0);
        imageView.setTranslateZ(120);
        imageView.setFitWidth(0.0);
        imageView.setFitHeight(0.0);



        Group root = new Group(imageView, model, model_titulo, model_des_1, model_des_2, precio, precio_actual, ahorro, casa, texto_logo, light1);

        Scene scene1 = new Scene(root, 1260, 700, true, SceneAntialiasing.BALANCED);

        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateX(scene1.getWidth() / -2.0);
        camera.setTranslateY(scene1.getHeight() / -2.0);


        /*Hacemos que se traslade desde la parte inferior
          hasta el centro de la pantalla*/
        TranslateTransition tr = new TranslateTransition(Duration.seconds(5), model);
        tr.setFromY(800.0);
        tr.setToY(0.0);
        tr.setFromX(0.0);
        tr.setToX(0.0);
        tr.play();
        //Ahora hacemos que rote sobre el eje y
        RotateTransition rt = new RotateTransition(Duration.seconds(10), model);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setAxis(new Point3D(0, 1, 0));
        rt.setDelay(Duration.millis(5000));
        rt.play();
        //Animación de salida
        TranslateTransition tr_salida = new TranslateTransition(Duration.seconds(2), model);
        tr_salida.setFromY(0.0);
        tr_salida.setToY(900.0);
        tr_salida.setFromX(0.0);
        tr_salida.setToX(0.0);
        tr_salida.setDelay(Duration.millis(13000));
        tr_salida.play();

        //animaciones de textos
        //Animación del título
        TranslateTransition trt = new TranslateTransition(Duration.seconds(2), model_titulo);
        trt.setFromY(-650.0);
        trt.setToY(-300.0);
        trt.setFromX(0.0);
        trt.setToX(0.0);
        trt.play();
        //Animación de salida
        TranslateTransition trt_salida = new TranslateTransition(Duration.seconds(2), model_titulo);
        trt_salida.setFromY(-300.0);
        trt_salida.setToY(-700.0);
        trt_salida.setFromX(0.0);
        trt_salida.setToX(0.0);
        trt_salida.setDelay(Duration.millis(13000));
        trt_salida.play();

        //Animación de la primera descripción
        TranslateTransition d1 = new TranslateTransition(Duration.seconds(2), model_des_1);
        d1.setFromY(0.0);
        d1.setToY(0.0);
        d1.setFromX(-600.0);
        d1.setToX(-400.0);
        d1.play();
        //Animación de salida
        TranslateTransition d1_salida = new TranslateTransition(Duration.seconds(2), model_des_1);
        d1_salida.setFromY(0.0);
        d1_salida.setToY(0.0);
        d1_salida.setFromX(-400.0);
        d1_salida.setToX(-1200.0);
        d1_salida.setDelay(Duration.millis(13000));
        d1_salida.play();

        //Animación de la segunda descripción
        TranslateTransition d2 = new TranslateTransition(Duration.seconds(2), model_des_2);
        d2.setFromY(0.0);
        d2.setToY(0.0);
        d2.setFromX(600.0);
        d2.setToX(400.0);
        d2.play();
        //Animación de salida
        TranslateTransition d2_salida = new TranslateTransition(Duration.seconds(2), model_des_2);
        d2_salida.setFromY(0.0);
        d2_salida.setToY(0.0);
        d2_salida.setFromX(400.0);
        d2_salida.setToX(1200.0);
        d2_salida.setDelay(Duration.millis(13000));
        d2_salida.play();


        //animación para el precio anterior
        TranslateTransition precio_t = new TranslateTransition(Duration.seconds(2), precio);
        precio_t.setFromY(400.0);
        precio_t.setToY(200.0);
        precio_t.setFromX(400.0);
        precio_t.setToX(400.0);
        precio_t.play();
        //animación de salida precio anterior
        TranslateTransition precio_t_salida = new TranslateTransition(Duration.seconds(2), precio);
        precio_t_salida.setFromY(200.0);
        precio_t_salida.setToY(600.0);
        precio_t_salida.setFromX(400.0);
        precio_t_salida.setToX(400.0);
        precio_t_salida.setDelay(Duration.millis(13000));
        precio_t_salida.play();

        //animación para el precio actual
        TranslateTransition precio_ta = new TranslateTransition(Duration.seconds(2), precio_actual);
        precio_ta.setFromY(400.0);
        precio_ta.setToY(240.0);
        precio_ta.setFromX(400.0);
        precio_ta.setToX(400.0);
        precio_ta.play();
        //animación de salida precio actual
        TranslateTransition precio_ta_salida = new TranslateTransition(Duration.seconds(2), precio_actual);
        precio_ta_salida.setFromY(2400.0);
        precio_ta_salida.setToY(600.0);
        precio_ta_salida.setFromX(0.0);
        precio_ta_salida.setToX(0.0);
        precio_ta_salida.setDelay(Duration.millis(13000));
        precio_ta_salida.play();

        //animación para oferta
        TranslateTransition precio_ahorro = new TranslateTransition(Duration.seconds(2), ahorro);
        precio_ahorro.setFromY(400.0);
        precio_ahorro.setToY(290.0);
        precio_ahorro.setFromX(400.0);
        precio_ahorro.setToX(400.0);
        precio_ahorro.play();

        //animacion de escala para oferta
        ScaleTransition scaleTransition_promo = new ScaleTransition(Duration.seconds(2));
        scaleTransition_promo.setFromX(40.0);
        scaleTransition_promo.setToX(50.0);
        scaleTransition_promo.setFromY(40.0);
        scaleTransition_promo.setToY(50.0);
        // Let the animation run forever
        scaleTransition_promo.setCycleCount(2);
        // Reverse direction on alternating cycles
        scaleTransition_promo.setAutoReverse(true);

        SequentialTransition Transition_pro = new SequentialTransition();
        Transition_pro.getChildren().addAll(scaleTransition_promo);
        Transition_pro.setNode(ahorro);
        Transition_pro.setCycleCount(PathTransition.INDEFINITE);
        Transition_pro.play();
        //animación de salida para la oferta
        TranslateTransition precio_ahorro_salida = new TranslateTransition(Duration.seconds(2), ahorro);
        precio_ahorro_salida.setFromY(290.0);
        precio_ahorro_salida.setToY(600.0);
        precio_ahorro_salida.setFromX(0.0);
        precio_ahorro_salida.setToX(0.0);
        precio_ahorro_salida.setDelay(Duration.millis(13000));
        precio_ahorro_salida.play();


        scene1.setCamera(camera);
        stage.setTitle("Celular");
        stage.setScene(scene1);
        stage.show();
    }

    private void loadScene3D_Portatil(Stage stage) throws IOException {

        AmbientLight light1 = new AmbientLight();

        Node model = Importer3D.load(getClass().getResource("models/portatil17.obj").toExternalForm());
        model.setScaleX(250.0);
        model.setScaleY(250.0);
        model.setScaleZ(250.0);
        model.setTranslateY(800);
        model.setTranslateX(-800);

        //PARA LOS TEXTOS
        Node model_titulo = Importer3D.load(getClass().getResource("titulos/computador.obj").toExternalForm());
        model_titulo.setScaleX(50.0);
        model_titulo.setScaleY(50.0);
        model_titulo.setScaleZ(50.0);
        model_titulo.setTranslateX(-2000);
        model_titulo.setTranslateY(-1500);

        Node model_des_1 = Importer3D.load(getClass().getResource("descripciones/computador.obj").toExternalForm());
        model_des_1.setScaleX(30.0);
        model_des_1.setScaleY(30.0);
        model_des_1.setScaleZ(30.0);
        model_des_1.setTranslateX(-2000);
        model_des_1.setTranslateY(-1500);


        Node precio = Importer3D.load(getClass().getResource("precios/precio_antes.obj").toExternalForm());
        precio.setScaleX(40.0);
        precio.setScaleY(40.0);
        precio.setScaleZ(40.0);
        precio.setTranslateX(-2000);
        precio.setTranslateY(-1500);

        Node precio_actual = Importer3D.load(getClass().getResource("precios/precio_despues.obj").toExternalForm());
        precio_actual.setScaleX(40.0);
        precio_actual.setScaleY(40.0);
        precio_actual.setScaleZ(40.0);
        precio_actual.setTranslateX(-2000);
        precio_actual.setTranslateY(-1500);

        Node ahorro = Importer3D.load(getClass().getResource("precios/ahorro_pre.obj").toExternalForm());
        ahorro.setScaleX(40.0);
        ahorro.setScaleY(40.0);
        ahorro.setScaleZ(40.0);
        ahorro.setTranslateX(-2000);
        ahorro.setTranslateY(-1500);

        //PARA EL LOGOTIPO
        Node casa = Importer3D.load(getClass().getResource("logo/casa.obj").toExternalForm());
        casa.setScaleX(12.0);
        casa.setScaleY(12.0);
        casa.setScaleZ(12.0);
        casa.setTranslateX(-540);
        casa.setTranslateY(-300);

        Node texto_logo = Importer3D.load(getClass().getResource("logo/texto_logo.obj").toExternalForm());
        texto_logo.setScaleX(30.0);
        texto_logo.setScaleY(30.0);
        texto_logo.setScaleZ(30.0);
        texto_logo.setTranslateX(-540);
        texto_logo.setTranslateY(-250);
        //animación para el logotipo
        RotateTransition rt_logo = new RotateTransition(Duration.seconds(13), casa);
        rt_logo.setCycleCount(PathTransition.INDEFINITE);
        rt_logo.setFromAngle(0);
        rt_logo.setToAngle(360);
        rt_logo.setAxis(new Point3D(1, 1, 1));
        rt_logo.play();

        ImageView imageView = new ImageView();
        Image bgimage = new Image("sample/fondos/fondo_general.jpg",true);
        imageView.setX(-690.0);
        imageView.setY(-410);
        imageView.setImage(bgimage);
        imageView.setFitHeight(700);
        imageView.setFitWidth(1260);
        imageView.setScaleZ(-300.0);
        imageView.setTranslateZ(160);
        imageView.setFitWidth(0.0);
        imageView.setFitHeight(0.0);

        Group root = new Group(imageView, model, model_titulo, model_des_1, precio, precio_actual, ahorro, casa, texto_logo, light1);

        Scene scene1 = new Scene(root, 1260, 700, true, SceneAntialiasing.BALANCED);

        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateX(scene1.getWidth() / -2.0);
        camera.setTranslateY(scene1.getHeight() / -2.0);


        /*Hacemos que se traslade desde la parte inferior derecha
          de la pantalla hasta la parte derecha*/
        TranslateTransition tra = new TranslateTransition(Duration.seconds(3), model);
        tra.setFromY(570.0);
        tra.setToY(0.0);
        tra.setFromX(800.0);
        tra.setToX(400.0);
        tra.play();
        //Hacemos que rote sobre el eje x
        RotateTransition rta = new RotateTransition(Duration.seconds(10), model);
        rta.setCycleCount(Animation.INDEFINITE);
        rta.setFromAngle(0);
        rta.setToAngle(360);
        rta.setAxis(new Point3D(1, 0, 0));
        rta.setDelay(Duration.millis(3000));
        rta.play();
        //Animación de salida
        TranslateTransition tra_salida = new TranslateTransition(Duration.seconds(2), model);
        tra_salida.setFromY(0.0);
        tra_salida.setToY(600.0);
        tra_salida.setFromX(400.0);
        tra_salida.setToX(800.0);
        tra_salida.setDelay(Duration.millis(12500));
        tra_salida.play();

        //animaciones de textos
        //animación para el título
        TranslateTransition trt = new TranslateTransition(Duration.seconds(2), model_titulo);
        trt.setFromY(-650.0);
        trt.setToY(-300.0);
        trt.setFromX(350.0);
        trt.setToX(350.0);
        trt.play();
        //animación de salida
        TranslateTransition trt_salida = new TranslateTransition(Duration.seconds(2), model_titulo);
        trt_salida.setFromY(-300.0);
        trt_salida.setToY(-700.0);
        trt_salida.setFromX(350.0);
        trt_salida.setToX(350.0);
        trt_salida.setDelay(Duration.millis(12500));
        trt_salida.play();

        //animación para la descripción
        TranslateTransition d1 = new TranslateTransition(Duration.seconds(2), model_des_1);
        d1.setFromY(0.0);
        d1.setToY(0.0);
        d1.setFromX(-600.0);
        d1.setToX(-250.0);
        d1.play();
        //animación de salida
        TranslateTransition d1_salida = new TranslateTransition(Duration.seconds(2), model_des_1);
        d1_salida.setFromY(0.0);
        d1_salida.setToY(0.0);
        d1_salida.setFromX(-250.0);
        d1_salida.setToX(-1200.0);
        d1_salida.setDelay(Duration.millis(12500));
        d1_salida.play();



        //animación para el precio anterior
        TranslateTransition precio_t = new TranslateTransition(Duration.seconds(2), precio);
        precio_t.setFromY(400.0);
        precio_t.setToY(200.0);
        precio_t.setFromX(400.0);
        precio_t.setToX(400.0);
        precio_t.play();
        //animación de salida precio anterior
        TranslateTransition precio_t_salida = new TranslateTransition(Duration.seconds(2), precio);
        precio_t_salida.setFromY(200.0);
        precio_t_salida.setToY(600.0);
        precio_t_salida.setFromX(400.0);
        precio_t_salida.setToX(400.0);
        precio_t_salida.setDelay(Duration.millis(12500));
        precio_t_salida.play();

        //animación para el precio actual
        TranslateTransition precio_ta = new TranslateTransition(Duration.seconds(2), precio_actual);
        precio_ta.setFromY(400.0);
        precio_ta.setToY(240.0);
        precio_ta.setFromX(400.0);
        precio_ta.setToX(400.0);
        precio_ta.play();
        //animación de salida precio actual
        TranslateTransition precio_ta_salida = new TranslateTransition(Duration.seconds(2), precio_actual);
        precio_ta_salida.setFromY(2400.0);
        precio_ta_salida.setToY(600.0);
        precio_ta_salida.setFromX(400.0);
        precio_ta_salida.setToX(400.0);
        precio_ta_salida.setDelay(Duration.millis(12500));
        precio_ta_salida.play();

        //animación para oferta
        TranslateTransition precio_ahorro = new TranslateTransition(Duration.seconds(2), ahorro);
        precio_ahorro.setFromY(400.0);
        precio_ahorro.setToY(290.0);
        precio_ahorro.setFromX(400.0);
        precio_ahorro.setToX(400.0);
        precio_ahorro.play();

        //animacion de escala para oferta
        ScaleTransition scaleTransition_promo = new ScaleTransition(Duration.seconds(2));
        scaleTransition_promo.setFromX(40.0);
        scaleTransition_promo.setToX(50.0);
        scaleTransition_promo.setFromY(40.0);
        scaleTransition_promo.setToY(50.0);
        // Let the animation run forever
        scaleTransition_promo.setCycleCount(2);
        // Reverse direction on alternating cycles
        scaleTransition_promo.setAutoReverse(true);

        SequentialTransition Transition_pro = new SequentialTransition();
        Transition_pro.getChildren().addAll(scaleTransition_promo);
        Transition_pro.setNode(ahorro);
        Transition_pro.setCycleCount(PathTransition.INDEFINITE);
        Transition_pro.play();
        //animación de salida para la oferta
        TranslateTransition precio_ahorro_salida = new TranslateTransition(Duration.seconds(2), ahorro);
        precio_ahorro_salida.setFromY(290.0);
        precio_ahorro_salida.setToY(600.0);
        precio_ahorro_salida.setFromX(400.0);
        precio_ahorro_salida.setToX(400.0);
        precio_ahorro_salida.setDelay(Duration.millis(12500));
        precio_ahorro_salida.play();

        //ANIMACIONES PARA TERMINAR
        TranslateTransition logo_animar = new TranslateTransition(Duration.seconds(2), casa);
        logo_animar.setFromY(-300.0);
        logo_animar.setToY(-50.0);
        logo_animar.setFromX(-540.0);
        logo_animar.setToX(0.0);
        logo_animar.setDelay(Duration.millis(15000));
        logo_animar.play();

        ScaleTransition scaleTransition_casa = new ScaleTransition(Duration.seconds(2));
        scaleTransition_casa.setFromX(12.0);
        scaleTransition_casa.setToX(40.0);
        scaleTransition_casa.setFromY(12.0);
        scaleTransition_casa.setToY(40.0);
        // Let the animation run forever
        scaleTransition_casa.setCycleCount(1);
        // Reverse direction on alternating cycles
        scaleTransition_casa.setAutoReverse(true);

        SequentialTransition Transition_casa = new SequentialTransition();
        Transition_casa.getChildren().addAll(scaleTransition_casa);
        Transition_casa.setNode(casa);
        Transition_casa.setCycleCount(1);
        Transition_casa.setDelay(Duration.millis(16000));
        Transition_casa.play();

        TranslateTransition logo_texto = new TranslateTransition(Duration.seconds(2), texto_logo);
        logo_texto.setFromY(-250.0);
        logo_texto.setToY(90.0);
        logo_texto.setFromX(-540.0);
        logo_texto.setToX(0.0);
        logo_texto.setDelay(Duration.millis(15000));
        logo_texto.play();

        ScaleTransition scaleTransition_txt_logo = new ScaleTransition(Duration.seconds(2));
        scaleTransition_txt_logo.setFromX(30.0);
        scaleTransition_txt_logo.setToX(70.0);
        scaleTransition_txt_logo.setFromY(30.0);
        scaleTransition_txt_logo.setToY(70.0);
        // Let the animation run forever
        scaleTransition_txt_logo.setCycleCount(1);
        // Reverse direction on alternating cycles
        scaleTransition_txt_logo.setAutoReverse(true);

        SequentialTransition Transition_txt_logo = new SequentialTransition();
        Transition_txt_logo.getChildren().addAll(scaleTransition_txt_logo);
        Transition_txt_logo.setNode(texto_logo);
        Transition_txt_logo.setCycleCount(1);
        Transition_txt_logo.setDelay(Duration.millis(16000));
        Transition_txt_logo.play();


        scene1.setFill(Color.WHITE);
        scene1.setCamera(camera);
        stage.setTitle("Computador portátil");
        stage.setScene(scene1);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}


/*
 * PAQUETE DE LA CLASE
 * -------------------
 *
 * Esta clase pertenece al paquete:
 *
 * com.ejemplo.perfil
 *
 * Debe estar ubicada normalmente en:
 *
 * src/main/java/com/ejemplo/perfil/PerfilController.java
 *
 * El paquete nos permite organizar las clases del proyecto.
 *
 * MainApplication, PerfilController y ResumenController
 * pueden pertenecer al mismo paquete.
 */
package com.ejemplo.perfil;


/*
 * IMPORTACIONES
 * -------------
 *
 * Importamos las clases de JavaFX y Java que necesitamos.
 */


/*
 * FXML
 * ----
 *
 * Es una anotación de JavaFX.
 *
 * Una anotación proporciona información adicional
 * sobre una clase, un atributo o un método.
 *
 * @FXML permite que FXMLLoader acceda a determinados
 * atributos y métodos privados del controlador.
 *
 * Esto es necesario para conectar los controles
 * y eventos definidos en el archivo FXML.
 */
import javafx.fxml.FXML;


/*
 * CheckBox
 * --------
 *
 * Representa una casilla de verificación.
 *
 * Puede estar:
 *
 * - Seleccionada (true).
 * - No seleccionada (false).
 *
 * Utilizaremos dos CheckBox para que el usuario
 * indique si le interesa Java y/o JavaFX.
 */
import javafx.scene.control.CheckBox;


/*
 * Label
 * -----
 *
 * Representa una etiqueta de texto.
 *
 * Sirve para mostrar información al usuario.
 *
 * En nuestro formulario la utilizamos para
 * mostrar mensajes de validación.
 */
import javafx.scene.control.Label;


/*
 * TextField
 * ---------
 *
 * Representa un campo de texto de una sola línea.
 *
 * Permite que el usuario escriba información.
 *
 * En nuestro ejemplo:
 *
 * - txtNombre almacena el nombre introducido.
 * - txtEmail almacena el correo electrónico.
 */
import javafx.scene.control.TextField;


/*
 * FXMLLoader
 * ----------
 *
 * Permite cargar una interfaz definida en FXML.
 *
 * En este controlador lo utilizaremos para
 * abrir una segunda pantalla:
 *
 * resumen-view.fxml
 */
import javafx.fxml.FXMLLoader;


/*
 * Scene
 * -----
 *
 * Representa el contenido de una ventana JavaFX.
 *
 * La segunda ventana tendrá su propia Scene.
 */
import javafx.scene.Scene;


/*
 * Stage
 * -----
 *
 * Representa una ventana.
 *
 * Crearemos un nuevo Stage para mostrar
 * el resumen del perfil.
 */
import javafx.stage.Stage;


/*
 * IOException
 * -----------
 *
 * Excepción relacionada con operaciones
 * de entrada y salida.
 *
 * Puede producirse al cargar el archivo FXML.
 */
import java.io.IOException;


/*
 * CLASE PerfilController
 * ----------------------
 *
 * Esta clase es el CONTROLADOR del formulario.
 *
 * En una aplicación JavaFX con FXML podemos separar:
 *
 * - MainApplication:
 *     Arranca la aplicación.
 *
 * - perfil-view.fxml:
 *     Define los elementos visuales del formulario.
 *
 * - PerfilController:
 *     Contiene la lógica del formulario.
 *
 * - styles.css:
 *     Define la apariencia visual.
 *
 *
 * La relación entre el FXML y este controlador
 * se establece mediante una declaración como:
 *
 * fx:controller="com.ejemplo.perfil.PerfilController"
 *
 * Esa declaración aparece en el elemento raíz
 * del archivo perfil-view.fxml.
 */
public class PerfilController {


    /*
     * ATRIBUTO txtNombre
     * ------------------
     *
     * @FXML:
     *     Permite que FXMLLoader conecte este atributo
     *     con el elemento correspondiente del FXML.
     *
     * private:
     *     El atributo solamente es accesible directamente
     *     desde esta clase.
     *
     * TextField:
     *     Es el tipo de objeto.
     *
     * txtNombre:
     *     Es el nombre de la variable.
     *
     *
     * En perfil-view.fxml debe existir un control como:
     *
     * <TextField fx:id="txtNombre" />
     *
     * IMPORTANTE:
     *
     * fx:id debe coincidir exactamente con el nombre
     * del atributo Java, respetando mayúsculas
     * y minúsculas.
     *
     * No creamos aquí el TextField mediante new.
     *
     * FXMLLoader crea el control a partir del FXML
     * e inyecta su referencia en este atributo.
     */
    @FXML
    private TextField txtNombre;


    /*
     * ATRIBUTO txtEmail
     * -----------------
     *
     * Referencia al campo donde el usuario
     * introduce su correo electrónico.
     *
     * En el FXML debe existir:
     *
     * <TextField fx:id="txtEmail" />
     *
     * Posteriormente utilizaremos getText()
     * para recuperar el contenido escrito.
     */
    @FXML
    private TextField txtEmail;


    /*
     * ATRIBUTO checkJava
     * ------------------
     *
     * Referencia a la casilla que representa
     * la preferencia por Java.
     *
     * En el FXML:
     *
     * <CheckBox fx:id="checkJava" text="Java" />
     *
     * El método isSelected() nos permitirá
     * saber si el usuario la ha marcado.
     */
    @FXML
    private CheckBox checkJava;


    /*
     * ATRIBUTO checkJavaFX
     * --------------------
     *
     * Referencia a la casilla que representa
     * la preferencia por JavaFX.
     *
     * En el FXML:
     *
     * <CheckBox fx:id="checkJavaFX" text="JavaFX" />
     */
    @FXML
    private CheckBox checkJavaFX;


    /*
     * ATRIBUTO lblResultado
     * ---------------------
     *
     * Referencia a una etiqueta del formulario.
     *
     * Se utiliza para mostrar mensajes al usuario.
     *
     * Por ejemplo:
     *
     * "Debes introducir nombre y correo electrónico."
     *
     * En el FXML:
     *
     * <Label fx:id="lblResultado" />
     *
     * El método setText() permitirá cambiar
     * el texto de esta etiqueta.
     */
    @FXML
    private Label lblResultado;


    /*
     * MÉTODO guardarPerfil()
     * ----------------------
     *
     * Este método se ejecuta cuando el usuario
     * pulsa el botón de guardar.
     *
     * En el archivo FXML debe existir
     * un botón con una declaración como:
     *
     * <Button
     *     text="Guardar"
     *     onAction="#guardarPerfil"
     * />
     *
     *
     * @FXML:
     *     Permite a FXMLLoader acceder al método.
     *
     * private:
     *     El método pertenece a la lógica interna
     *     de este controlador.
     *
     * void:
     *     Indica que el método no devuelve un valor.
     *
     * guardarPerfil():
     *     Nombre del método.
     *
     * Los paréntesis vacíos indican que no recibe
     * parámetros.
     *
     * Su trabajo consiste en:
     *
     * 1. Leer el nombre y el correo.
     * 2. Comprobar que no estén vacíos.
     * 3. Obtener las preferencias seleccionadas.
     * 4. Abrir la ventana de resumen.
     */
    @FXML
    private void guardarPerfil() {


        /*
         * PASO 1: LEER EL NOMBRE
         * ----------------------
         *
         * String:
         *     Tipo de dato que representa texto.
         *
         * nombre:
         *     Variable local donde guardaremos el texto.
         *
         * txtNombre:
         *     Referencia al TextField del formulario.
         *
         * getText():
         *     Método que devuelve el texto que contiene
         *     ese TextField.
         *
         * Ejemplo:
         *
         * Si el usuario escribe "Ana",
         *
         * nombre contendrá "Ana".
         */
        String nombre = txtNombre.getText();


        /*
         * PASO 2: LEER EL CORREO ELECTRÓNICO
         * ----------------------------------
         *
         * Recuperamos el contenido del segundo
         * campo de texto.
         *
         * Ejemplo:
         *
         * email = "ana@ejemplo.com"
         */
        String email = txtEmail.getText();


        /*
         * PASO 3: VALIDAR LOS CAMPOS
         * --------------------------
         *
         * if:
         *     Es una estructura condicional.
         *
         * Permite ejecutar código solamente cuando
         * se cumple una determinada condición.
         *
         *
         * nombre.isBlank()
         * ----------------
         *
         * Devuelve true si el String está vacío
         * o contiene únicamente espacios en blanco
         * u otros caracteres considerados espacios.
         *
         * Ejemplos:
         *
         * "".isBlank()       -> true
         * "   ".isBlank()    -> true
         * "Ana".isBlank()    -> false
         *
         *
         * ||:
         *     Es el operador lógico OR (O).
         *
         * La condición será verdadera cuando
         * AL MENOS UNO de los campos esté vacío.
         *
         * Por ejemplo:
         *
         * nombre vacío | email vacío | resultado
         * -------------|-------------|----------
         * true         | true        | true
         * true         | false       | true
         * false        | true        | true
         * false        | false       | false
         */
        if (nombre.isBlank() || email.isBlank()) {


            /*
             * MOSTRAR UN MENSAJE DE ERROR
             * ---------------------------
             *
             * lblResultado:
             *     Etiqueta que existe en el FXML.
             *
             * setText():
             *     Modifica el texto que muestra
             *     esa etiqueta.
             *
             * El usuario verá este mensaje
             * dentro de la ventana principal.
             */
            lblResultado.setText(
                    "Debes introducir nombre y correo electrónico."
            );


            /*
             * return
             * ------
             *
             * Finaliza inmediatamente la ejecución
             * del método guardarPerfil().
             *
             * Como el método devuelve void,
             * escribimos simplemente:
             *
             * return;
             *
             * Esto impide que el programa continúe
             * y abra la ventana de resumen
             * cuando faltan datos obligatorios.
             */
            return;
        }


        /*
         * PASO 4: PREPARAR LAS PREFERENCIAS
         * ---------------------------------
         *
         * Creamos una variable String llamada
         * preferencias.
         *
         * Inicialmente contiene una cadena vacía:
         *
         * ""
         *
         * Iremos añadiendo texto dependiendo
         * de las casillas seleccionadas.
         */
        String preferencias = "";


        /*
         * COMPROBAR LA CASILLA DE JAVA
         * ----------------------------
         *
         * checkJava.isSelected()
         *     Devuelve un valor boolean:
         *
         *     true  -> la casilla está marcada.
         *     false -> la casilla no está marcada.
         *
         * Si está marcada, añadimos "Java ".
         *
         *
         * +=:
         *     Es un operador de asignación compuesta.
         *
         * En este caso:
         *
         * preferencias += "Java ";
         *
         * Equivale a:
         *
         * preferencias = preferencias + "Java ";
         *
         * El espacio después de Java sirve
         * para separar las preferencias.
         */
        if (checkJava.isSelected()) {
            preferencias += "Java ";
        }


        /*
         * COMPROBAR LA CASILLA DE JAVAFX
         * ------------------------------
         *
         * Si el usuario ha marcado JavaFX,
         * añadimos ese texto a la variable.
         *
         * Posibles resultados:
         *
         * Ninguna casilla -> ""
         * Solo Java       -> "Java "
         * Solo JavaFX     -> "JavaFX"
         * Ambas           -> "Java JavaFX"
         *
         * Observa que el código permite continuar
         * aunque no haya ninguna preferencia marcada.
         */
        if (checkJavaFX.isSelected()) {
            preferencias += "JavaFX";
        }


        /*
         * PASO 5: ABRIR LA SEGUNDA VENTANA
         * --------------------------------
         *
         * Llamamos al método abrirVentanaResumen().
         *
         * Le pasamos tres argumentos:
         *
         * - nombre
         * - email
         * - preferencias
         *
         * Estos datos serán recibidos por los
         * parámetros del método.
         *
         * De esta forma, la ventana de resumen
         * podrá mostrar la información introducida.
         */
        abrirVentanaResumen(
                nombre,
                email,
                preferencias
        );

    } // Fin de guardarPerfil()


    /*
     * MÉTODO limpiarFormulario()
     * --------------------------
     *
     * Se ejecuta cuando el usuario pulsa
     * el botón Limpiar.
     *
     * En el FXML:
     *
     * <Button
     *     text="Limpiar"
     *     onAction="#limpiarFormulario"
     * />
     *
     * Su objetivo es devolver los controles
     * a su estado inicial.
     */
    @FXML
    private void limpiarFormulario() {


        /*
         * clear()
         * -------
         *
         * Elimina el contenido de un TextField.
         *
         * Después de ejecutar clear(),
         * el campo queda vacío.
         */
        txtNombre.clear();

        txtEmail.clear();


        /*
         * setSelected(false)
         * ------------------
         *
         * Cambia el estado de un CheckBox.
         *
         * true  -> marca la casilla.
         * false -> desmarca la casilla.
         *
         * Aquí desmarcamos ambas preferencias.
         */
        checkJava.setSelected(false);

        checkJavaFX.setSelected(false);


        /*
         * LIMPIAR EL MENSAJE
         * ------------------
         *
         * Sustituimos el texto de la etiqueta
         * por una cadena vacía.
         *
         * De esta forma desaparece cualquier
         * mensaje anterior.
         */
        lblResultado.setText("");

    } // Fin de limpiarFormulario()


    /*
     * MÉTODO abrirVentanaResumen()
     * ----------------------------
     *
     * Este método crea una segunda ventana
     * para mostrar los datos del perfil.
     *
     *
     * private:
     *     Solo puede llamarse directamente
     *     desde esta clase.
     *
     * void:
     *     No devuelve ningún valor.
     *
     *
     * PARÁMETROS
     * ----------
     *
     * String nombre:
     *     Recibe el nombre del usuario.
     *
     * String email:
     *     Recibe el correo electrónico.
     *
     * String preferencias:
     *     Recibe las preferencias seleccionadas.
     *
     * Son variables locales del método.
     *
     * Cuando guardarPerfil() llama a este método,
     * los valores de sus argumentos se asignan
     * a estos parámetros.
     *
     *
     * No lleva @FXML porque no se invoca
     * directamente desde el archivo FXML.
     *
     * Lo llamamos desde nuestro propio código Java.
     */
    private void abrirVentanaResumen(
            String nombre,
            String email,
            String preferencias) {


        /*
         * BLOQUE try
         * ----------
         *
         * Permite ejecutar instrucciones
         * que pueden producir excepciones.
         *
         * Si se produce una IOException dentro
         * del bloque, el programa saltará
         * al bloque catch correspondiente.
         */
        try {


            /*
             * PASO 1: CREAR EL CARGADOR FXML
             * -----------------------------
             *
             * FXMLLoader loader:
             *     Declaramos una variable de tipo
             *     FXMLLoader.
             *
             * new FXMLLoader(...):
             *     Creamos el objeto cargador.
             *
             *
             * getClass()
             * ----------
             *
             * Devuelve el objeto Class correspondiente
             * a la clase del objeto actual.
             *
             * En este caso, normalmente será
             * PerfilController.
             *
             *
             * getResource("resumen-view.fxml")
             * --------------------------------
             *
             * Busca el archivo FXML de la
             * segunda pantalla.
             *
             * Como la ruta no empieza por "/",
             * se busca relativa al paquete.
             *
             * Ubicación esperada:
             *
             * src/main/resources/com/ejemplo/perfil/
             *     resumen-view.fxml
             *
             * Si no existe, getResource() devuelve null
             * y la carga posterior fallará.
             */
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "resumen-view.fxml"
                            )
                    );


            /*
             * PASO 2: CARGAR LA SEGUNDA INTERFAZ
             * ----------------------------------
             *
             * loader.load():
             *     Lee el archivo resumen-view.fxml
             *     y crea sus componentes JavaFX.
             *
             * Si el FXML declara:
             *
             * fx:controller="com.ejemplo.perfil.ResumenController"
             *
             * FXMLLoader también crea el controlador
             * correspondiente.
             *
             *
             * new Scene(loader.load()):
             *     Construye una nueva escena utilizando
             *     el nodo raíz obtenido del FXML.
             *
             * Aquí no indicamos ancho ni alto.
             *
             * JavaFX calcula el tamaño inicial
             * de la escena a partir del tamaño
             * preferido de su contenido.
             */
            Scene scene =
                    new Scene(loader.load());


            /*
             * PASO 3: OBTENER EL CONTROLADOR
             * ------------------------------
             *
             * Una vez ejecutado loader.load(),
             * podemos recuperar el controlador
             * de la segunda pantalla.
             *
             *
             * loader.getController()
             * ----------------------
             *
             * Devuelve el controlador asociado
             * al FXML que acabamos de cargar.
             *
             * En nuestro ejemplo esperamos
             * un objeto ResumenController.
             *
             *
             * ResumenController controller:
             *     Declaramos una variable llamada
             *     controller que guardará la referencia
             *     al controlador de la segunda pantalla.
             *
             * IMPORTANTE:
             *
             * Debemos obtenerlo DESPUÉS de load(),
             * porque la carga es la que crea
             * el controlador.
             *
             * El archivo resumen-view.fxml debe
             * tener correctamente configurado
             * su fx:controller.
             */
            ResumenController controller =
                    loader.getController();


            /*
             * PASO 4: PASAR LOS DATOS AL CONTROLADOR
             * --------------------------------------
             *
             * controller.cargarDatos(...)
             * ---------------------------
             *
             * Invoca un método del controlador
             * de la segunda ventana.
             *
             * Le pasamos:
             *
             * - El nombre.
             * - El correo electrónico.
             * - Las preferencias.
             *
             * ResumenController debe definir
             * un método compatible, por ejemplo:
             *
             * public void cargarDatos(
             *         String nombre,
             *         String email,
             *         String preferencias) {
             *
             *     // Actualizar los controles
             *     // de la segunda pantalla.
             * }
             *
             *
             * De esta manera comunicamos datos
             * entre dos controladores diferentes.
             *
             * La primera pantalla recoge los datos.
             *
             * La segunda pantalla los muestra.
             */
            controller.cargarDatos(
                    nombre,
                    email,
                    preferencias
            );


            /*
             * PASO 5: CREAR UNA NUEVA VENTANA
             * -------------------------------
             *
             * Stage stage = new Stage();
             *
             * Crea una nueva ventana independiente.
             *
             * Es diferente del Stage principal
             * que recibíamos en MainApplication.
             *
             * Ahora tendremos:
             *
             * - Primera ventana: formulario.
             * - Segunda ventana: resumen.
             *
             * Ambas pueden permanecer abiertas
             * al mismo tiempo.
             */
            Stage stage = new Stage();


            /*
             * PASO 6: ESTABLECER EL TÍTULO
             * ----------------------------
             *
             * Modificamos el título de la
             * nueva ventana.
             */
            stage.setTitle(
                    "Resumen del perfil"
            );


            /*
             * PASO 7: ASIGNAR LA ESCENA
             * ------------------------
             *
             * Asociamos la Scene que contiene
             * el resumen a la nueva ventana.
             */
            stage.setScene(scene);


            /*
             * PASO 8: MOSTRAR LA VENTANA
             * -------------------------
             *
             * show() hace visible el nuevo Stage.
             *
             * No cierra la ventana original.
             *
             * Si el usuario vuelve a pulsar Guardar,
             * este código creará otra ventana
             * adicional de resumen.
             */
            stage.show();


            /*
             * BLOQUE catch
             * ------------
             *
             * Si se produce una IOException
             * dentro del bloque try, se ejecuta
             * este bloque.
             *
             *
             * IOException e
             * -------------
             *
             * IOException:
             *     Tipo de excepción que capturamos.
             *
             * e:
             *     Variable que contiene la excepción.
             */
        } catch (IOException e) {


            /*
             * printStackTrace()
             * -----------------
             *
             * Muestra en la consola información
             * detallada sobre la excepción.
             *
             * Incluye normalmente:
             *
             * - Tipo de excepción.
             * - Mensaje del error.
             * - Métodos por los que ha pasado.
             * - Archivos y líneas relacionados.
             *
             * Es útil durante el aprendizaje
             * y la depuración.
             *
             * Sin embargo, no informa directamente
             * al usuario de que se ha producido
             * un problema.
             *
             * En una aplicación más completa
             * podríamos mostrar un Alert de JavaFX
             * y registrar el error en un sistema
             * de logging.
             */
            e.printStackTrace();

        }

    } // Fin de abrirVentanaResumen()

} // Fin de PerfilController

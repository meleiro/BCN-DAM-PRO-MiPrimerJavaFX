
/*
 * PAQUETE AL QUE PERTENECE ESTA CLASE
 * -----------------------------------
 *
 * La palabra reservada "package" indica el paquete de Java
 * al que pertenece este archivo.
 *
 * Los paquetes sirven para organizar las clases de un proyecto
 * y evitar conflictos entre clases que tengan el mismo nombre.
 *
 * En nuestro proyecto, esta clase debe estar ubicada en:
 *
 * src/main/java/com/ejemplo/perfil/MainApplication.java
 *
 * Es importante distinguir entre:
 *
 * - El paquete Java: com.ejemplo.perfil
 * - La carpeta física: com/ejemplo/perfil
 *
 * IntelliJ puede mostrar varias carpetas agrupadas con puntos.
 */
package com.ejemplo.perfil;


/*
 * IMPORTACIONES
 * -------------
 *
 * La instrucción "import" permite utilizar clases que están
 * definidas en otros paquetes.
 *
 * JavaFX está organizado en diferentes paquetes según la
 * función de sus clases.
 */


/*
 * Application
 * -----------
 *
 * Es la clase base de las aplicaciones JavaFX.
 *
 * Nuestra clase MainApplication heredará de Application.
 *
 * Application se encarga de gestionar el ciclo de vida
 * de una aplicación JavaFX:
 *
 * 1. Inicialización de la aplicación.
 * 2. Ejecución del método start().
 * 3. Finalización de la aplicación.
 *
 * La aplicación JavaFX dispone de métodos como:
 *
 * - init(): se ejecuta antes de start(), si se sobrescribe.
 * - start(): crea y muestra la interfaz gráfica.
 * - stop(): se ejecuta cuando finaliza la aplicación,
 *           si se sobrescribe.
 */
import javafx.application.Application;


/*
 * FXMLLoader
 * ----------
 *
 * Permite leer un archivo FXML y convertir sus etiquetas
 * XML en objetos JavaFX reales.
 *
 * Por ejemplo, si en el FXML aparece:
 *
 * <Button text="Guardar" />
 *
 * FXMLLoader creará un objeto Button de JavaFX.
 *
 * También puede crear y conectar el controlador declarado
 * mediante fx:controller dentro del archivo FXML.
 */
import javafx.fxml.FXMLLoader;


/*
 * Scene
 * -----
 *
 * Representa el contenido de una ventana JavaFX.
 *
 * Dentro de una Scene se encuentran los elementos visuales:
 *
 * - Botones.
 * - Etiquetas.
 * - Campos de texto.
 * - Contenedores.
 * - Imágenes.
 * - Etc.
 *
 * Una Scene tiene un nodo raíz (root) que contiene
 * la estructura visual de la interfaz.
 */
import javafx.scene.Scene;


/*
 * Stage
 * -----
 *
 * Representa una ventana de la aplicación.
 *
 * Podemos imaginar:
 *
 * Stage = ventana.
 * Scene = contenido de la ventana.
 *
 * Un Stage puede tener:
 *
 * - Título.
 * - Tamaño.
 * - Escena.
 * - Icono.
 * - Estado visible u oculto.
 */
import javafx.stage.Stage;


/*
 * IOException
 * -----------
 *
 * Es una excepción relacionada con operaciones de
 * entrada y salida.
 *
 * En este programa puede producirse al cargar el FXML,
 * por ejemplo, si el archivo está mal formado o no
 * puede leerse correctamente.
 *
 * El método start() declara "throws IOException"
 * para permitir que esta excepción se propague.
 *
 * Importante:
 * Otros errores de carga, como una ruta inexistente,
 * pueden provocar excepciones diferentes.
 */
import java.io.IOException;


/*
 * DECLARACIÓN DE LA CLASE PRINCIPAL
 * ---------------------------------
 *
 * public:
 *     Permite acceder a la clase desde otros lugares.
 *
 * class:
 *     Indica que estamos declarando una clase.
 *
 * MainApplication:
 *     Es el nombre de nuestra clase.
 *
 * extends Application:
 *     Significa que MainApplication HEREDA de Application.
 *
 * Gracias a esta herencia, JavaFX reconoce esta clase
 * como una aplicación gráfica.
 */
public class MainApplication extends Application {


    /*
     * MÉTODO start()
     * --------------
     *
     * Este es el método principal del ciclo de vida
     * de una aplicación JavaFX.
     *
     * JavaFX lo llama automáticamente cuando la
     * aplicación está preparada para crear la interfaz.
     *
     * No tenemos que llamar manualmente a start().
     *
     *
     * @Override
     * ---------
     *
     * Indica que estamos sobrescribiendo un método
     * definido en la clase Application.
     *
     * El compilador comprueba que realmente existe
     * un método compatible en la clase padre.
     *
     *
     * public void start(Stage stage)
     * ------------------------------
     *
     * public:
     *     El método es accesible públicamente.
     *
     * void:
     *     No devuelve ningún valor.
     *
     * start:
     *     Nombre del método.
     *
     * Stage stage:
     *     Es un parámetro que recibe el método.
     *
     *     Stage es el tipo de dato.
     *     stage es el nombre de la variable.
     *
     *     JavaFX nos entrega la ventana principal
     *     a través de este parámetro.
     *
     *
     * throws IOException
     * ------------------
     *
     * Declara que el método puede propagar
     * una excepción IOException.
     */
    @Override
    public void start(Stage stage) throws IOException {


        /*
         * PASO 1: CREAR EL CARGADOR FXML
         * -----------------------------
         *
         * FXMLLoader es una clase.
         *
         * loader es una variable que almacenará
         * una referencia a un objeto FXMLLoader.
         *
         * new FXMLLoader(...)
         *     Crea un nuevo objeto de esa clase.
         *
         * Dentro del constructor indicamos la
         * ubicación del archivo FXML que queremos cargar.
         */
        FXMLLoader loader = new FXMLLoader(

                /*
                 * MainApplication.class
                 * ---------------------
                 *
                 * Obtiene el objeto Class que representa
                 * nuestra clase MainApplication.
                 *
                 * No crea una instancia de MainApplication.
                 *
                 *
                 * getResource("perfil-view.fxml")
                 * --------------------------------
                 *
                 * Busca un recurso llamado perfil-view.fxml.
                 *
                 * Como el nombre no empieza por "/",
                 * la búsqueda se realiza con respecto
                 * al paquete de MainApplication.
                 *
                 * En nuestro caso:
                 *
                 * com.ejemplo.perfil
                 *
                 * Por tanto, Maven debería tener el FXML en:
                 *
                 * src/main/resources/com/ejemplo/perfil/
                 *     perfil-view.fxml
                 *
                 * Al compilar el proyecto, Maven normalmente
                 * copia los recursos a target/classes.
                 *
                 * getResource() devuelve una URL si encuentra
                 * el archivo, o null si no existe.
                 *
                 * Si devuelve null, la carga fallará.
                 */
                MainApplication.class.getResource("perfil-view.fxml")
        );


        /*
         * PASO 2: CREAR LA ESCENA
         * -----------------------
         *
         * new Scene(...)
         *     Crea una nueva escena JavaFX.
         *
         * El constructor recibe:
         *
         * 1. El nodo raíz de la interfaz.
         * 2. El ancho inicial de la escena.
         * 3. El alto inicial de la escena.
         *
         *
         * loader.load()
         * -------------
         *
         * Lee el archivo FXML y construye
         * los objetos JavaFX que contiene.
         *
         * Por ejemplo, si el FXML tiene:
         *
         * <VBox>
         *     <Label text="Nombre" />
         *     <TextField />
         * </VBox>
         *
         * FXMLLoader crea un VBox que contiene
         * un Label y un TextField.
         *
         * El objeto VBox sería el nodo raíz.
         *
         * Si el FXML declara un controlador mediante
         * fx:controller, FXMLLoader también lo instancia
         * y conecta los elementos y eventos declarados.
         *
         *
         * 500, 500
         * --------
         *
         * Indican:
         *
         * Ancho inicial = 500 píxeles.
         * Alto inicial  = 500 píxeles.
         *
         * Son dimensiones iniciales de la escena;
         * no impiden que la ventana pueda redimensionarse.
         */
        Scene scene = new Scene(loader.load(), 500, 500);


        /*
         * PASO 3: APLICAR UNA HOJA DE ESTILOS CSS
         * --------------------------------------
         *
         * JavaFX permite personalizar la apariencia
         * de los controles utilizando archivos CSS.
         *
         * Por ejemplo, en styles.css podemos definir:
         *
         * .contenedor {
         *     -fx-background-color: lightblue;
         * }
         *
         * De esta forma separamos:
         *
         * FXML -> Estructura de la interfaz.
         * CSS  -> Apariencia de la interfaz.
         * Java -> Lógica de la aplicación.
         *
         *
         * scene.getStylesheets()
         * ----------------------
         *
         * Devuelve la lista de hojas de estilo
         * asociadas a esta escena.
         *
         *
         * .add(...)
         * ---------
         *
         * Añade un elemento a esa lista.
         *
         *
         * getResource("styles.css")
         * -------------------------
         *
         * Busca el archivo styles.css dentro
         * del mismo paquete de recursos.
         *
         * Su ubicación esperada es:
         *
         * src/main/resources/com/ejemplo/perfil/styles.css
         *
         *
         * .toExternalForm()
         * -----------------
         *
         * Convierte la URL del recurso en una cadena
         * de texto que JavaFX puede utilizar para
         * localizar la hoja de estilos.
         *
         * IMPORTANTE:
         *
         * Si styles.css no existe, getResource()
         * devolverá null y la llamada a
         * toExternalForm() provocará un error.
         */
        scene.getStylesheets().add(
                MainApplication.class
                        .getResource("styles.css")
                        .toExternalForm()
        );


        /*
         * PASO 4: ESTABLECER EL TÍTULO DE LA VENTANA
         * -----------------------------------------
         *
         * setTitle() modifica el texto que aparece
         * en la barra de título de la ventana.
         *
         * "Gestor de Perfil - JavaFX" es un String,
         * es decir, una cadena de caracteres.
         */
        stage.setTitle("Gestor de Perfil - JavaFX");


        /*
         * PASO 5: ASOCIAR LA ESCENA A LA VENTANA
         * -------------------------------------
         *
         * setScene(scene) indica qué contenido
         * debe mostrar el Stage.
         *
         * Hasta este momento hemos creado:
         *
         * - El cargador FXML.
         * - Los componentes de la interfaz.
         * - La escena.
         * - La hoja de estilos.
         *
         * Ahora colocamos esa escena dentro
         * de la ventana principal.
         */
        stage.setScene(scene);


        /*
         * PASO 6: MOSTRAR LA VENTANA
         * -------------------------
         *
         * show() hace visible el Stage.
         *
         * Sin esta llamada, la ventana principal
         * no se mostraría.
         *
         * JavaFX continúa gestionando la interfaz
         * y respondiendo a eventos del usuario:
         *
         * - Clics.
         * - Pulsaciones de teclado.
         * - Movimiento del ratón.
         * - Redimensionamiento de la ventana.
         * - Etc.
         */
        stage.show();

    } // Fin del método start()


    /*
     * MÉTODO main()
     * -------------
     *
     * Es el punto de entrada tradicional de
     * una aplicación Java.
     *
     * La máquina virtual Java puede comenzar
     * la ejecución invocando este método.
     *
     *
     * public:
     *     Permite que sea accesible desde fuera.
     *
     * static:
     *     Pertenece a la clase, no a un objeto concreto.
     *
     * void:
     *     No devuelve ningún valor.
     *
     * String[] args:
     *     Permite recibir argumentos desde la
     *     línea de comandos.
     *
     *
     * launch()
     * --------
     *
     * Es un método estático heredado de Application.
     *
     * Inicia el entorno JavaFX.
     *
     * Durante ese proceso, JavaFX crea una instancia
     * de nuestra clase MainApplication y llama
     * a los métodos de su ciclo de vida.
     *
     * Finalmente ejecuta start(stage), donde
     * construimos y mostramos la ventana.
     *
     * En este programa no utilizamos los argumentos
     * de la línea de comandos.
     */
    public static void main(String[] args) {

        launch();

    } // Fin del método main()

} // Fin de la clase MainApplication

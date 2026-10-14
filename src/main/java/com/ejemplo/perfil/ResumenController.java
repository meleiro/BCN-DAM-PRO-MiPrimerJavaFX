
/*
 * PAQUETE DE LA CLASE
 * -------------------
 *
 * Esta clase pertenece al paquete:
 *
 * com.ejemplo.perfil
 *
 * Su ubicación habitual dentro de un proyecto Maven es:
 *
 * src/main/java/com/ejemplo/perfil/ResumenController.java
 *
 * Al estar en el mismo paquete que PerfilController,
 * ambas clases pueden referenciarse directamente
 * por su nombre, sin necesidad de importarse.
 */
package com.ejemplo.perfil;


/*
 * IMPORTACIÓN DE @FXML
 * --------------------
 *
 * FXML es una anotación de JavaFX.
 *
 * Una anotación comienza con el símbolo @.
 *
 * @FXML permite que el cargador FXMLLoader
 * acceda a campos y métodos del controlador,
 * incluso cuando están declarados como private.
 *
 * Se utiliza para conectar:
 *
 * - Elementos visuales del archivo FXML.
 * - Atributos del controlador Java.
 * - Métodos que responden a eventos.
 */
import javafx.fxml.FXML;


/*
 * IMPORTACIÓN DE Label
 * --------------------
 *
 * Label es un control JavaFX que permite
 * mostrar texto en la interfaz gráfica.
 *
 * No está pensado para que el usuario escriba
 * directamente en él.
 *
 * Para modificar su contenido utilizaremos:
 *
 * setText(String texto)
 */
import javafx.scene.control.Label;


/*
 * IMPORTACIÓN DE Stage
 * --------------------
 *
 * Stage representa una ventana JavaFX.
 *
 * Necesitamos esta clase porque el botón
 * "Cerrar" debe cerrar la ventana de resumen.
 *
 * El método close() de Stage permite hacerlo.
 */
import javafx.stage.Stage;


/*
 * DECLARACIÓN DE LA CLASE
 * -----------------------
 *
 * public:
 *     La clase es accesible desde otros paquetes.
 *
 * class:
 *     Indica que declaramos una clase Java.
 *
 * ResumenController:
 *     Es el nombre de la clase.
 *
 *
 * Esta clase actúa como controlador del archivo:
 *
 * resumen-view.fxml
 *
 * En dicho archivo debe aparecer una declaración
 * equivalente a:
 *
 * fx:controller="com.ejemplo.perfil.ResumenController"
 *
 * FXMLLoader utiliza esta información para crear
 * el controlador y conectar sus elementos.
 */
public class ResumenController {


    /*
     * ATRIBUTO lblNombre
     * ------------------
     *
     * @FXML:
     *     Permite la inyección del control desde FXML.
     *
     * private:
     *     Este atributo solo puede utilizarse
     *     directamente dentro de esta clase.
     *
     * Label:
     *     Tipo de dato del atributo.
     *
     * lblNombre:
     *     Nombre de la variable.
     *
     *
     * Debe existir en resumen-view.fxml
     * una etiqueta con el mismo fx:id:
     *
     * <Label fx:id="lblNombre" />
     *
     * Cuando FXMLLoader carga la interfaz,
     * crea el Label y asigna su referencia
     * al atributo lblNombre.
     *
     * No necesitamos escribir:
     *
     * lblNombre = new Label();
     *
     * porque FXMLLoader se ocupa de crear
     * e inyectar el objeto.
     */
    @FXML
    private Label lblNombre;


    /*
     * ATRIBUTO lblEmail
     * -----------------
     *
     * Referencia a la etiqueta donde mostraremos
     * el correo electrónico del usuario.
     *
     * En el archivo FXML debe existir:
     *
     * <Label fx:id="lblEmail" />
     *
     * Es importante respetar exactamente
     * las mayúsculas y minúsculas del nombre.
     */
    @FXML
    private Label lblEmail;


    /*
     * ATRIBUTO lblPreferencias
     * -----------------------
     *
     * Referencia a la etiqueta donde mostraremos
     * las preferencias seleccionadas.
     *
     * Por ejemplo:
     *
     * Preferencias: Java JavaFX
     *
     * En resumen-view.fxml:
     *
     * <Label fx:id="lblPreferencias" />
     */
    @FXML
    private Label lblPreferencias;


    /*
     * MÉTODO cargarDatos()
     * --------------------
     *
     * Este método recibe la información
     * procedente de la primera ventana.
     *
     * No lo llama directamente el usuario.
     *
     * Lo llama PerfilController mediante:
     *
     * controller.cargarDatos(
     *         nombre,
     *         email,
     *         preferencias
     * );
     *
     *
     * public:
     *     Permite invocar este método desde
     *     otra clase, como PerfilController.
     *
     * void:
     *     Indica que no devuelve ningún valor.
     *
     * cargarDatos:
     *     Nombre del método.
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
     * Estos parámetros son variables locales.
     *
     * Sus valores se reciben cuando otra clase
     * invoca el método.
     *
     *
     * ¿POR QUÉ NO UTILIZAMOS @FXML AQUÍ?
     * ---------------------------------
     *
     * Porque cargarDatos() no es un método
     * invocado desde el archivo FXML.
     *
     * Lo llamamos directamente desde código Java.
     *
     * Por tanto, no necesita la anotación @FXML.
     */
    public void cargarDatos(
            String nombre,
            String email,
            String preferencias) {


        /*
         * MOSTRAR EL NOMBRE
         * -----------------
         *
         * lblNombre:
         *     Referencia al Label del FXML.
         *
         * setText():
         *     Cambia el texto que muestra
         *     esa etiqueta.
         *
         *
         * "Nombre: " + nombre
         * -------------------
         *
         * El operador + permite concatenar
         * cadenas de texto.
         *
         * Concatenar significa unir textos.
         *
         * Por ejemplo, si:
         *
         * nombre = "Ana"
         *
         * La expresión:
         *
         * "Nombre: " + nombre
         *
         * produce:
         *
         * "Nombre: Ana"
         *
         * Ese será el texto visible en la etiqueta.
         */
        lblNombre.setText(
                "Nombre: " + nombre
        );


        /*
         * MOSTRAR EL CORREO ELECTRÓNICO
         * -----------------------------
         *
         * Utilizamos nuevamente setText().
         *
         * Si el parámetro email contiene:
         *
         * "ana@ejemplo.com"
         *
         * La etiqueta mostrará:
         *
         * Email: ana@ejemplo.com
         *
         * Observa que el texto literal
         * "Email: " incluye un espacio final.
         *
         * Ese espacio separa la descripción
         * del valor recibido.
         */
        lblEmail.setText(
                "Email: " + email
        );


        /*
         * MOSTRAR LAS PREFERENCIAS
         * ------------------------
         *
         * Actualizamos la tercera etiqueta.
         *
         * Si el usuario seleccionó ambas casillas,
         * el parámetro preferencias puede contener:
         *
         * "Java JavaFX"
         *
         * El resultado visible será:
         *
         * Preferencias: Java JavaFX
         *
         * Si no seleccionó ninguna casilla,
         * preferencias puede ser una cadena vacía.
         *
         * En ese caso aparecerá solamente:
         *
         * Preferencias:
         */
        lblPreferencias.setText(
                "Preferencias: " + preferencias
        );

    } // Fin del método cargarDatos()


    /*
     * MÉTODO cerrarVentana()
     * ----------------------
     *
     * Este método se ejecuta cuando el usuario
     * pulsa el botón "Cerrar".
     *
     * En resumen-view.fxml debe existir
     * un botón con una declaración como:
     *
     * <Button
     *     text="Cerrar"
     *     onAction="#cerrarVentana"
     * />
     *
     *
     * @FXML:
     *     Permite a FXMLLoader acceder al método.
     *
     * private:
     *     Solo es accesible directamente
     *     desde esta clase.
     *
     * void:
     *     No devuelve ningún valor.
     *
     * cerrarVentana():
     *     No recibe parámetros.
     *
     *
     * OBJETIVO
     * --------
     *
     * Obtener la ventana que contiene
     * la etiqueta lblNombre y cerrarla.
     */
    @FXML
    private void cerrarVentana() {


        /*
         * OBTENER LA VENTANA ACTUAL
         * ------------------------
         *
         * Esta es la instrucción más interesante
         * de toda la clase:
         *
         * Stage stage =
         *         (Stage) lblNombre
         *                 .getScene()
         *                 .getWindow();
         *
         * Vamos a analizarla paso a paso.
         *
         *
         * 1. lblNombre
         * ------------
         *
         * Es una etiqueta de la segunda ventana.
         *
         * Como forma parte de la interfaz,
         * podemos utilizarla para averiguar
         * a qué escena pertenece.
         *
         *
         * 2. .getScene()
         * --------------
         *
         * Devuelve la Scene que contiene
         * a la etiqueta lblNombre.
         *
         * Recuerda:
         *
         * Scene representa el contenido
         * de una ventana JavaFX.
         *
         *
         * 3. .getWindow()
         * ---------------
         *
         * Devuelve la ventana asociada
         * a esa Scene.
         *
         * El tipo devuelto es Window,
         * una clase más general que Stage.
         *
         *
         * 4. (Stage)
         * ----------
         *
         * Esto se llama conversión de tipos
         * o CASTING.
         *
         * Estamos indicando que queremos
         * tratar el objeto Window como Stage.
         *
         * Esto es válido porque sabemos
         * que la escena se ha colocado
         * dentro de un Stage.
         *
         * No todos los objetos Window
         * son necesariamente Stage.
         *
         * Por tanto, esta conversión supone
         * que la ventana realmente es un Stage.
         *
         *
         * 5. Stage stage
         * --------------
         *
         * Declaramos una variable llamada stage,
         * de tipo Stage.
         *
         * Guardamos en ella una referencia
         * a la ventana del resumen.
         *
         *
         * IMPORTANTE
         * ----------
         *
         * Aquí NO estamos creando una ventana nueva.
         *
         * No utilizamos:
         *
         * new Stage()
         *
         * Estamos recuperando una referencia
         * a una ventana que ya existe.
         */
        Stage stage =
                (Stage) lblNombre
                        .getScene()
                        .getWindow();


        /*
         * CERRAR LA VENTANA
         * -----------------
         *
         * stage.close()
         *
         * Solicita el cierre de la ventana
         * representada por ese Stage.
         *
         * En nuestro caso, cierra la ventana
         * de resumen.
         *
         * La ventana principal del formulario
         * permanece abierta.
         *
         * Esto permite al usuario:
         *
         * - Volver al formulario.
         * - Modificar sus datos.
         * - Pulsar Guardar otra vez.
         * - Abrir un nuevo resumen.
         *
         * close() no significa que toda
         * la aplicación tenga que terminar.
         *
         * Si quedan otras ventanas abiertas,
         * JavaFX normalmente seguirá ejecutándose.
         */
        stage.close();

    } // Fin del método cerrarVentana()

} // Fin de la clase ResumenController

package com.aprendiendokotlin.objetos;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.view.MotionEvent;

/**
 * Clase Renderiza (OpenGL 1.x)
 *
 * @author Jhonny Felipez
 * @version 1.0 02/04/2014
 *
 */
public class Renderiza extends GLSurfaceView implements Renderer {

    /* Objeto */
    private Cubo cubo;
    private Piso piso;
    private Circulo circulo;
    private Tallo tallo;
    private Hojas hojas;
    private Casa casa;
    private Casa casa1;
    private Casa casa2;
    private Casa casa3;
    private Casa casa4;
    private Casa casa5;
    private Cesped cesped;
    private float[][] v = new float[100][2];
    int max =100;
    /* Inicializa ubicaci�n de la vista del observador */
    private final float[] vectorEntrada = { 0, 0, -1, 1 };
    private static float posicion[] = { 0, 0, 0 };
    private final float[] direccion = new float[4];

    /* Tama�o de la ventana en pixeles */
    private int alto;
    private int ancho;

    /* Para la rotaci�n y traslaci�n */
    private float rotY;
    private	float antX;

    final float[] matriz = new float[16];

    /* Contexto */
    Context contexto;

    public Renderiza(Context contexto) {
        super(contexto);
        this.contexto = contexto;
        this.setRenderer(this);
        this.requestFocus();
        this.setFocusableInTouchMode(true);
        this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {

        cubo = new Cubo();
        piso = new Piso();
        circulo = new Circulo(0.5f, 360, true);
        casa = new Casa();
        casa1 = new Casa();
        casa2 = new Casa();
        casa3 = new Casa();
        casa4 = new Casa();
        casa5 = new Casa();
        cesped = new Cesped();
        tallo = new Tallo();
        hojas= new Hojas();
        for (int i = 0; i < max; i++) {
            v[i][0]=(float)(Math.random()*200)-100;
            v[i][1]=(float)(Math.random()*200)-100;
        }

        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glClearColor(135/255f, 206/255f, 235/256f, 1);

    }

    @Override
    public void onDrawFrame(GL10 gl) {

        /* Borra el buffer de la ventana y del z-buffer */
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        /* Botones de las opciones */
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrthof(-4, 4, -6, 6, 1, 100);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        // Bot�n avanza
        gl.glPushMatrix();
        gl.glTranslatef(0, -4, 0);
        circulo.dibuja(gl);
        gl.glPopMatrix();

        // Bot�n retrocede
        gl.glPushMatrix();
        gl.glTranslatef(0, -5.5f, 0);
        circulo.dibuja(gl);
        gl.glPopMatrix();

        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 67, ancho / (float)alto, 1f, 100f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glRotatef(-rotY, 0, 1, 0);
        gl.glTranslatef(-posicion[0], -posicion[1], -posicion[2]);

        // Piso
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, -6);
        cesped.dibuja(gl);
        //piso.dibuja(gl);
        gl.glPopMatrix();
/*
        // Cubo 1
        gl.glPushMatrix();
        gl.glTranslatef(-1.5f, 0, -6);
        gl.glScalef(0.5f, 0.5f, 0.5f);
        cubo.dibuja(gl);
        gl.glPopMatrix();

        // Cubo 2
        gl.glPushMatrix();
        gl.glTranslatef(1.5f, 0, -6);
        gl.glScalef(0.5f, 0.5f, 0.5f);
        cubo.dibuja(gl);
        gl.glPopMatrix();

*/
        //casa
        gl.glPushMatrix();
        for (int i = 0; i < max; i++) {
            gl.glPushMatrix();
            //gl.glRotatef(45,0,0, 1);
            //float var =2+(float)(Math.random()*2);
            gl.glScalef(0.2f, 1.2f, 0.2f);
            //(x,y,z)
            gl.glTranslatef( v[i][0],0.6f, v[i][1]);
            hojas.dibuja(gl);
            //gl.glScalef(0.2f, 1.2f, 0.2f);
            //(x,y,z)
            gl.glTranslatef( 0,0.2f, 0.2f);
            hojas.dibuja(gl);
            gl.glTranslatef( 0,0.2f, 0.2f);
            hojas.dibuja(gl);
            ///cerramos
            gl.glScalef(0.2f, 0.1f, 0.2f);
            gl.glTranslatef( 0,-14.5f,0);
            tallo.dibuja(gl);
            gl.glPopMatrix();
        }
        gl.glTranslatef(8f, 1, 5);
        gl.glScalef(0.5f, 0.5f, 0.5f);
        casa.dibuja(gl);
        gl.glPopMatrix();

        //casa1
        gl.glPushMatrix();
        gl.glTranslatef(3f, 1, 5);
        gl.glScalef(0.5f, 0.5f, 0.5f);
        casa1.dibuja(gl);
        gl.glPopMatrix();

        //casa2
        gl.glPushMatrix();
        gl.glTranslatef(-2f, 1, 5);
        gl.glScalef(0.5f, 0.5f, 0.5f);
        casa2.dibuja(gl);
        gl.glPopMatrix();

        //casa3
        gl.glPushMatrix();
        gl.glTranslatef(8f, 1, -7);
        gl.glScalef(0.5f, 0.5f, 0.5f);
        casa3.dibuja(gl);
        gl.glPopMatrix();

        //casa4
        gl.glPushMatrix();
        gl.glTranslatef(3f, 1, -7);
        gl.glScalef(0.5f, 0.5f, 0.5f);
        casa4.dibuja(gl);
        gl.glPopMatrix();

        //casa5
        gl.glPushMatrix();
        gl.glTranslatef(-2f, 1, -7);
        gl.glScalef(0.5f, 0.5f, 0.5f);
        casa5.dibuja(gl);
        gl.glPopMatrix();


        gl.glFlush();

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int w, int h) {

        ancho = w;
        alto = h;

        gl.glViewport(0, 0, ancho, alto);

        GLU.gluLookAt(gl, 0, 0, 0, 0, 0, -1, 0, 1, 0);

    }

    /**
     * Maneja los eventos del movimiento en la pantalla t�ctil.
     */
    @Override
    public boolean onTouchEvent(MotionEvent e) {

        /* Obtiene la coordenada de la pantalla */
        float posx = e.getX();
        float posy = e.getY();

        /* Se considera cuando se levanta el dedo de la pantalla. */
        if (e.getAction() == MotionEvent.ACTION_DOWN) {

            /* En coordenadas del OpenGL */
            posx = ((posx / (float) ancho) * 8) - 4;
            posy = ((1 - posy / (float) alto) * 12) - 6;

            /* Verifica �rea elegida */
            if (puntoEstaDentroDelCirculo(posx, posy, 0, -4f, 0.5f)) { // Avanza
                Matrix.setIdentityM(matriz, 0);
                Matrix.rotateM(matriz, 0, rotY, 0, 1, 0);
                Matrix.multiplyMV(direccion, 0, matriz, 0, vectorEntrada, 0);

                posicion[0] = posicion[0] + direccion[0] * 0.3f;
                posicion[1] = posicion[1] + direccion[1] * 0.3f;
                posicion[2] = posicion[2] + direccion[2] * 0.3f;

            } else if (puntoEstaDentroDelCirculo(posx, posy, 0, -5.5f, 0.5f)) { // Retrocede
                Matrix.setIdentityM(matriz, 0);
                Matrix.rotateM(matriz, 0, rotY, 0, 1, 0);
                Matrix.multiplyMV(direccion, 0, matriz, 0, vectorEntrada, 0);

                posicion[0] = posicion[0] - direccion[0] * 0.3f;
                posicion[1] = posicion[1] - direccion[1] * 0.3f;
                posicion[2] = posicion[2] - direccion[2] * 0.3f;
            }
            requestRender();
        } else if (e.getAction() == MotionEvent.ACTION_MOVE) {
            if(antX == -1) {
                antX = posx;
            } else {
                rotY = rotY + (posx - antX) / 10;
                antX = posx;
            }

            requestRender();
        } else {
            antX = -1;
        }
        return true;
    }

    private boolean puntoEstaDentroDelCirculo(float posx, float posy, float x,
                                              float y, float radio) {
        return (distancia2(posx, posy, x, y) < radio * radio);
    }

    public float distancia2(float x1, float y1, float x2, float y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}

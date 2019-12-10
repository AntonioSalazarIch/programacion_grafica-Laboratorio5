package com.aprendiendokotlin.objetos;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Hojas {
	/**
	 *   3 --------- 2
	 *   / |       / |
	 *  /  |      /  |
	 * 7 --------- 6 |
	 * |   |      |  |
	 * |  0 ------|-- 1
	 * | /        | /
	 * |/         |/
	 * 4 --------- 5
	 */
	/* Las coordenadas cartesianas (x, y, z) */

	private float vertices[] = new float[] {
			// Frente
			-1, -1, 1, // 4 0
			1, -1, 1, // 5 1
			0, 0, 1, // 6 2
			0, 0, 1, // 7 3
			// Atr�s
			0, 0, 1, // 3 4
			0, 0, 1, // 2 5
			1, -1, -1, // 1 6
			-1, -1, -1, // 0 7
			// Izquierda
			-1, -1, -1, // 0 8
			-1, -1, 1, // 4 9
			0, 0, 1, // 7 10
			0, 0, 1, // 3 11
			// Derecha
			1, -1, 1, // 5 12
			1, -1, -1, // 1 13
			0, 0, 1, // 2 14
			0, 0, 1, // 6 15
			
	};

	/* Los colores x c/v�rtice (r,g,b,a) */
	byte maxColor = (byte)255;
	int a=76, b=175, c=80;
	int d=139, e=195, f=74;
	private byte colores[] = new byte[] {
			// Frente - lila
			(byte)a, (byte)b, (byte)c, 0, // 4 0
			(byte)a, (byte)b, (byte)c, 0, // 4 0
			(byte)a, (byte)b, (byte)c, 0, // 4 0
			(byte)a, (byte)b, (byte)c, 0, // 4 0
			// Atr�s - amarillo
			(byte)a, (byte)b, (byte)c, 0, // 4 0
			(byte)a, (byte)b, (byte)c, 0, // 4 0
			(byte)a, (byte)b, (byte)c, 0, // 4 0
			(byte)a, (byte)b, (byte)c, 0, // 4 0
			// Izquierda - celeste
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			// Derecha - rojo
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			// Abajo - azul
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			
	};
	/* Indices */
	private short indices[] = new short [] {
			0, 1, 2, 0, 2, 3, // Frente
			4, 5, 6, 4, 6, 7, // Atr�s
			8, 9, 10, 8, 10, 11, // Izquierda
			12, 13, 14, 12, 14, 15, // Derecha
			
			
	};
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;
	public Hojas() {
		/* Lee los v�rtices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer

		/* Lee los colores */
		bufColores = ByteBuffer.allocateDirect(colores.length);
		bufColores.put(colores);
		bufColores.position(0); // puntero al principio del buffer
		/* Lee los indices */
		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
		bufIndices.put(indices);
		bufIndices.rewind(); // puntero al principio del buffer
	}
	public void dibuja(GL10 gl) {
		/* Se habilita el acceso al arreglo de v�rtices */
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		/* Se habilita el acceso al arreglo de colores */
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		/* Se especifica los datos del arreglo de v�rtices */
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
		/* Se especifica los datos del arreglo de colores */
		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
		/* Se dibuja el cubo */
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
		/* Se deshabilita el acceso a los arreglos */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}
}

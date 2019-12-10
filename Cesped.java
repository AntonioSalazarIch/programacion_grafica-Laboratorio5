package com.aprendiendokotlin.objetos;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Cesped {
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
			// Abajo
			-100,-1,-100, // 0 16
			100,-1,-100, // 1 17
			100,-1, 100, // 5 18
			-100,-1, 100, // 4 19
	};

	/* Los colores x c/v�rtice (r,g,b,a) */
	byte maxColor = (byte)255;
	int a=121, b=85, c=72;
	int d=121, e=85, f=72;
	private byte colores[] = new byte[] {
			// Abajo - azul
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			(byte)d, (byte)e, (byte)f, 0, // 4 0
			(byte)d, (byte)e, (byte)f, 0, // 4 0

	};
	/* Indices */
	private short indices[] = new short [] {
			0, 1, 2, 0, 2, 3, // Frente
	};
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;
	public Cesped() {
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
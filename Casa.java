package com.aprendiendokotlin.objetos;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Casa {
	
	

	/* Coordenadas cartesianas (x, y, z) */
	private float vertices[] = new float [] {

//			 // atras
			-3, -4,  3+2, //0
		     3, -4,  3+2, //1
			 3,  0,  3+2, //2
			-3,  0,  3+2, //3

			// adelante
			-3, -4, -3, //4
			 3, -4, -3, //5
			 3,  0, -3, //6
			-3,  0, -3, //7
//2
//			//abajo
			-3, -4,  3+2, //8
			 3, -4,  3+2, //9
		     3, -4, -3, //10
			-3, -4, -3, //11
			  //112
//	   		// Derecha
			3, -4,  3+2, //12
			3,  0,  3+2, //13
			3, -4, -3, //14
			3,  0, -3, //15
//			// Izquierda
			-3, -4,  3+2, //16
			-3,  0,  3+2, //17
			-3, -4, -3, //18
			-3,  0, -3, //19

//			techo atras
			 3,  0,  3+2, //20
			-3,  0,  3+2, //21
			 0,  2,  3+2, //22

//			techo delante.
			 3,  0, -3, //23
			-3,  0, -3, //24
			 0,  2, -3, //25
// 			techo derecho
			3,  0,  3+2, //26
			3,  0, -3, //27
			0,  2, -3, //28
			0,  2,  3+2, //29
//			techo izq
			-3,  0,  3+2, //30
			-3,  0, -3, //31
			 0,  2, -3, //32
			 0,  2,  3+2, //33
			//puerta

			// adelante
			-3+2.001f, -4.001f, -3.001f, //34
			3-2.001f, -4.001f, -3.001f, //35
			3-2.001f,  -2.001f, -3.001f, //36
			-3+2.001f,  -2.001f, -3.001f, //37

	};

	private float vertices1[] = new float [] {
			// adelante
			-3+2.001f, 0.001f, -3.001f, //0
			3-2.001f, 0.001f, -3.001f, //1
			3-2.001f,  1.001f, -3.001f, //2
			-3+2.001f,  1.001f, -3.001f, //3

			0.001f, 0.001f, -3.001f, //4
			0.001f,  1.001f, -3.001f, //5

			// Derecha
			3.001f, -1,  0.5f, //6
			3.001f,  -3,  0.5f, //7
			3.001f, -1, -2.5f, //8
			3.001f,  -3, -2.5f, //9

			// Derecha
		3.001f, -1,  1.5f, //10
			3.001f,  -3,  1.5f, //11
			3.001f, -1, 4.5f, //12
			3.001f,  -3, 4.5f, //13
//izq
			-3.001f, -1,  0.5f, //14
			-3.001f,  -3,  0.5f, //15
			-3.001f, -1, -2.5f, //16
			-3.001f,  -3, -2.5f, //17

			// izq
			-3.001f, -1,  1.5f, //18
			-3.001f,  -3,  1.5f, //19
			-3.001f, -1, 4.5f, //20
			-3.001f,  -3, 4.5f, //21
/*******************************************/
//
			3.001f, -1,  -1f, //22
			3.001f,  -3,  -1f, //23
			-3.001f, -1,  -1f, //24
			-3.001f,  -3,  -1f, //25

			// izq
			3.001f, -1,  3, //26
			3.001f,  -3,  3, //27
			-3.001f, -1,  3, //28
			-3.001f,  -3,  3, //29

	};
	byte maxColor = (byte)255;
	
	/* Los colores x c/v�rtice (r,g,b,a) */
	private byte colores1[] = new byte[] {
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0
			0, 0, 0, 1, // 0


	};
	private byte colores[] = new byte[] {
			54, 111, (byte)244,1, // 0
			54, 111, (byte)244,1, // 1
			54, 111, (byte)244,1, // 2
			54, 111, (byte)244,1, // 23

			(byte)240, 88, (byte)216,1,
			(byte)240, 88, (byte)216,1,
			(byte)240, 88, (byte)216,1,
			(byte)240, 88, (byte)216,1,

			(byte)246, 11, 4, 1,
			(byte)246, 11, 4, 1,
			(byte)246, 11, 4, 1,
			(byte)246, 11, 4, 1,

			maxColor, 0, 0, 1, // 0
			maxColor, 0, 0, 1, // 1
			maxColor, 0, 0, 1, // 2
			maxColor, 0, 0, 1, // 2

            0, 0, maxColor, 1, // 0
            0, 0, maxColor, 1, // 1
            0, 0, maxColor, 1, // 2
            0, 0, maxColor, 1, // 3

			maxColor, 0, 0, 1, // 0
			maxColor, 0, 0, 1, // 1
			maxColor, 0, 0, 1, // 2
			maxColor, 0, 0, 1, // 2

			maxColor, 0, 0, 1, // 0
			maxColor, 0, 0, 1, // 1
			maxColor, 0, 0, 1, // 2
			maxColor, 0, 0, 1, // 2

		0, 0, maxColor, 1, // 0
		0, 0, maxColor, 1, // 1
		0, 0, maxColor, 1, // 2
		0, 0, maxColor, 1, // 3
		
		0, maxColor, 0, 1, // 0
		0, maxColor, 0, 1, // 1
		0, maxColor, 0, 1, // 2
		0, maxColor, 0, 1, // 2
		
		maxColor, maxColor, 0, 1, // 0
		maxColor, maxColor, 0, 1, // 1
		maxColor, maxColor, 0, 1, // 2
		maxColor, maxColor, 0, 1, // 2

		maxColor, 0, maxColor, 1, // 0
		maxColor, 0, maxColor, 1, // 1
		maxColor, 0, maxColor, 1, // 2
		maxColor, 0, maxColor, 1, // 2

			maxColor, maxColor, maxColor, 1, // 0
			maxColor, maxColor, maxColor, 1, // 1
			maxColor, maxColor, maxColor, 1, // 2

			maxColor, maxColor, 0, 1, // 0
			maxColor, maxColor, 0, 1, // 1
			maxColor, maxColor, 0, 1, // 2

			0, 0, maxColor, 1, // 0
			0, 0, maxColor, 1, // 1
			0, 0, maxColor, 1, // 2
			0, 0, maxColor, 1, // 3

			maxColor, 0, 0, 1, // 0
			maxColor, 0, 0, 1, // 1
			maxColor, 0, 0, 1, // 2
			maxColor, 0, 0, 1, // 2
	};
	

	
	/* Indices */
	private short indices[] = new short [] {
		//  T1          T2
		0,  1,  2, 0, 2, 3,// atras
		4, 5, 6, 4, 6, 7, //delante
		8, 9, 10, 8, 10, 11, // Abajo
		12, 13, 14, 13, 14, 15, // derecha
		16, 17, 18, 17, 18, 19, // izquierda
			20, 21, 22, //techo atras
			23, 24, 25, //techo delante
			26, 27, 28, 26,28,29,
			30, 31, 32, 30, 32, 33,
			34, 35, 36, 34, 36, 37,
	};
	private short indices1[] = new short [] {
			0, 1,
			2, 3,
			0, 3,
			1, 2,
			4, 5,
			6, 7,
			8, 9,
			6, 8,
			7, 9,
			10, 11,
			12, 13,
			10, 12,
			11, 13,

			14, 15,
			16, 17,
			14, 16,
			15, 17,

			18, 19,
			20, 21,
			18, 20,
			19, 21,

			22, 23,
			24, 25,

			26, 27,
			28, 29,

	};
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;
	private FloatBuffer bufVertices1;
	private ByteBuffer bufColores1;
	private ShortBuffer bufIndices1;

	public Casa() {
		
		/* Lee los v�rtices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
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

		ByteBuffer bufByte1 = ByteBuffer.allocateDirect(vertices1.length * 4);
		bufByte1.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
		bufVertices1 = bufByte1.asFloatBuffer(); // Convierte de byte a float
		bufVertices1.put(vertices1);
		bufVertices1.rewind(); // puntero al principio del buffer

		/* Lee los colores */
		bufColores1 = ByteBuffer.allocateDirect(colores1.length);
		bufColores1.put(colores1);
		bufColores1.position(0); // puntero al principio del buffer

		/* Lee los indices */
		bufByte = ByteBuffer.allocateDirect(indices1.length * 2);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufIndices1 = bufByte.asShortBuffer(); // Convierte de byte a short
		bufIndices1.put(indices1);
		bufIndices1.rewind(); // puntero al principio del buffer
		
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

		/* Renderiza las primitivas desde los datos de los arreglos (v�rtices,
		 * colores e �ndices) */
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
/******************************************/
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices1);

		/* Se especifica los datos del arreglo de colores */
		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores1);

		/* Renderiza las primitivas desde los datos de los arreglos (v�rtices,
		 * colores e �ndices) */
		gl.glDrawElements(GL10.GL_LINES, indices1.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices1);


		/*************************/
		/* Se deshabilita el acceso al arreglo de v�rtices */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		//* Se deshabilita el acceso al arreglo de colores */
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		
	}
}

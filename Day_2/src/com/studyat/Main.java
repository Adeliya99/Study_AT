package com.studyat;

public class Main {

    public static void main(String[] args) {
	    AbstractVector2d vec1 = new Vector2d(1, 2);
	    Vector2d vec2 = new Vector2d(3, 4);

	    AbstractVector3d vec3 = new Vector3d(1, 2, 3);
	    Vector3d vec4 = new Vector3d(4, 5, 6);

        System.out.println(vec1.sumVec(vec2).toString());
		System.out.println(vec1.subVec(vec2).toString());
		System.out.println(vec1.scalar(vec2));
		System.out.println(vec3.sumVec(vec4).toString());
		System.out.println(vec3.subVec(vec4).toString());
		System.out.println(vec3.scalar(vec4));
		System.out.println(vec3.vector(vec4).toString());
    }
}

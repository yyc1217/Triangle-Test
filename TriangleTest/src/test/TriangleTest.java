package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;


import main.Triangle;
import main.TriangleType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class TriangleTest {
	
	private int a;
	private int b;
	private int c;
	private TriangleType expected;
	
	public TriangleTest(int a, int b, int c, TriangleType expected){
		this.a = a;
		this.b = b;
		this.c = c;
		this.expected = expected;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] data = new Object[][]{
				
				//邊長皆為0
				{0, 0, 0, TriangleType.NOT_A_TRIANGLE},
				
				//邊長有一邊為0
				{0, 1, 1, TriangleType.NOT_A_TRIANGLE},
				{1, 0, 1, TriangleType.NOT_A_TRIANGLE},
				{1, 1, 0, TriangleType.NOT_A_TRIANGLE},
				
				//邊長有一邊為負數
				{-1, 1, 1, TriangleType.NOT_A_TRIANGLE},
				{1, -1, 1, TriangleType.NOT_A_TRIANGLE},
				{1, 1, -1, TriangleType.NOT_A_TRIANGLE},
				
				//有兩邊長相加等於第三邊
				{2, 4, 6, TriangleType.NOT_A_TRIANGLE},
				{4, 9, 5, TriangleType.NOT_A_TRIANGLE},
				{8, 4, 4, TriangleType.NOT_A_TRIANGLE},
				
				//有兩邊長相加小於第三邊
				{3, 3, 8, TriangleType.NOT_A_TRIANGLE},
				{2, 5, 1, TriangleType.NOT_A_TRIANGLE},
				{7, 3, 3, TriangleType.NOT_A_TRIANGLE},
				
				//全等三角形
				{5, 5, 5, TriangleType.EQUILATERAL},
				
				//等腰三角形
				{3, 3, 4, TriangleType.ISOSCELES},
				{7, 8, 7, TriangleType.ISOSCELES},
				{5, 6, 6, TriangleType.ISOSCELES},
				
				//直角三角形
				{3, 4, 5, TriangleType.SCALENE},
				{3, 5, 4, TriangleType.SCALENE},
				{5, 4, 3, TriangleType.SCALENE},
				
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void testTraingle() {
		TriangleType actual = new Triangle(a, b, c).getType();
		assertEquals("", expected, actual);
	}

}

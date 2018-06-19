package chapterB7;

public class Testmemo {

	/*A=D+E+F
	 * D:Aの対角成分
	 * E:Aの下三角成分
	 * F:Aの上三角成分
	 *
	 * Jacobi
	 * x1=-D^(-1)(E+F)x0+D^-1*b
	 *
	 * Gauss-Seidel
	 * (D+E)x1=-F*x0+b
	 * すなわちx1=D^-1(b-E*x1-F*x0)
	 *
	 * SOR
	 * x1=D^-1(b-E*x2-F*x0)
	 * x2=x0+w(x1-x0)
	 * 
	 * 反復行列は-まで含まれる
	 * 
	 * Jacobi法の収束条件:反復行列の固有値すべてが-1<λ<1であること
	 * 
	 * 連立Newton
	 * (x1,y1)=(x0,y0)-J^(-1)(f1(x0,y0),f2(x0,y0))
	 * pivougaussで解く
	 * 
	 * Newton
	 * 反復式:x1=x0-f(x0)/f'(x0)
	 * 収束次数:2次(重解を持つなら1次)
	 * 
	 * Secant
	 * 反復式:x2=x1-f(x1)(x1-x0)/(f(x1)-f(x0))
	 * 収束次数:(1+√5)/2(重解を持つなら1次)
	 * 
	 * parallelchord
	 * 反復式:x1=x0-f(x0)/f'(x!)
	 * 収束次数:1次(重解を持つなら?)
	 * 
	 * Aが正定値対称行列ならコレスキー分解が使える
	 * A=L*L^t
	 * 
	 * SORの最適緩和係数は
	 * w=2/(1+√(1-(ρ(B))^2))
	 *
	 * //mathemarhicaで固有値を求めるときはEigenvalues[]
	 */

}

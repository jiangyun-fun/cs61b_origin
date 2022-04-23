public class NBody {
	
	public static double readRadius(String txt) {
		In in = new In(txt);
		
		int number = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
/*	
	public static Planet[] readPlanets(String txt) {
		Planet[] allPlanets = new Planet[5];
		
		In in = new In(txt);
		
		int number = in.readInt();
		double radius = in.readDouble();
		
		for(int i = 0;i < allPlanets.length; i++) {
			allPlanets[i].xxPos = in.readDouble();
			allPlanets[i].yyPos = in.readDouble();
			allPlanets[i].xxVel = in.readDouble();
			allPlanets[i].xxVel = in.readDouble();
			allPlanets[i].mass = in.readDouble();
			allPlanets[i].imgFileName = in.readString();
			}	
		return allPlanets;
		}
*/
	public static Planet[] readPlanets(String filename){
		In in = new In(filename);
		int num = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[num];
		for (int i = 0; i < num; i++) {
			double xp = in.readDouble();
			double yp = in.readDouble();
			double vx = in.readDouble();
			double vy = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xp, yp, vx, vy, m, img);	
		}
		return planets;
	}

}

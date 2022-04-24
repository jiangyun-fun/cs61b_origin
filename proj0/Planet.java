public class Planet {
	private static double G = 6.67e-11;
	
	public double xxPos,yyPos,xxVel,yyVel,mass;
	public String imgFileName;
	
	public Planet(double xP, double yP, double xV,
            double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass  = m;
		imgFileName = img;
	}
	
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
	
	public  double calcDistance(Planet planet) {
		double Distance = 0;
		Distance = Math.sqrt(Math.pow(this.xxPos - planet.xxPos, 2)+Math.pow(this.yyPos - planet.yyPos, 2));
		
		return Distance;
	}
	
	public double calcForceExertedBy(Planet planet) {
		double Distance = calcDistance(planet);
		double ForceExertedBy = G*mass*planet.mass/Distance/Distance;
		return ForceExertedBy;
	}
	
	public double calcForceExertedByX(Planet planet) {
		double Distance = calcDistance(planet);
		double ForceExertedBy = calcForceExertedBy(planet);
		double ForceExertedByX = ForceExertedBy*(planet.xxPos-xxPos)/Distance;
		return ForceExertedByX;
	}

	public double calcForceExertedByY(Planet planet) {
		double Distance = calcDistance(planet);
		double ForceExertedBy = calcForceExertedBy(planet);
		double ForceExertedByY = ForceExertedBy*(planet.yyPos-yyPos)/Distance;
		return ForceExertedByY;
	}
	
	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double NetForceExertedByX = 0;
		for(Planet planet : allPlanets) {
			if(equals(planet))	continue;
			NetForceExertedByX += calcForceExertedByX(planet);
		}
		return NetForceExertedByX;
	}
	
	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double NetForceExertedByY = 0;
		for(Planet planet : allPlanets) {
			if(equals(planet))	continue;
			NetForceExertedByY += calcForceExertedByY(planet);
		}
		return NetForceExertedByY;
	}

	public void update(double dt,double fX,double fY) {
		double aX = fX/mass;
		double aY = fY/mass;
		
		xxVel = xxVel + aX*dt;
		yyVel = yyVel + aY*dt;
		
		xxPos = xxPos + xxVel*dt;
		yyPos = yyPos + yyVel*dt;
		
	}
	
	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}
}



















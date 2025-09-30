public class FusionExperience extends UserExperiencePrototype {
    private String username;
    private String planType = "Fusion";
    String menu = "Menú Fusión";
    String offers, banners, language;

    //Constructor:
    public FusionExperience() {}

    //Redefinición de clone:
    @Override
    public FusionExperience clone() {
        FusionExperience newExperience = new FusionExperience();
        newExperience.setUsername(this.username);
        newExperience.setPlanType(this.planType);
        newExperience.setMenu(this.planType);
        newExperience.setOffers(this.offers);
        newExperience.setBanners(this.banners);
        newExperience.setLanguage(this.language);
        return newExperience;
    }
}
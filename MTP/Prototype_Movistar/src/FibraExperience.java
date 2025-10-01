public class FibraExperience extends UserExperiencePrototype{
    private String username, planType, menu,
            offers, banners, language;

    public FibraExperience(){}
    // Es protected porque solo lo vamos a usar en PrototypeRegister
    protected FibraExperience(String planType, String menu, String banners){
        this.planType = planType;
        this.menu = menu;
        this.banners = banners;
    }

    //Redefinición de clone:
    @Override
    public FibraExperience clone() {
        FibraExperience newExperience = new FibraExperience();
        newExperience.setUsername(this.username);
        newExperience.setPlanType(this.planType);
        newExperience.setMenu(this.planType);
        newExperience.setOffers(this.offers);
        newExperience.setBanners(this.banners);
        newExperience.setLanguage(this.language);
        return newExperience;
    }
}
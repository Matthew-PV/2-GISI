public class MovilExperience extends UserExperiencePrototype{
    private String username, planType, menu,
            offers, banners, language;

    public MovilExperience() {}
    // Es protected porque solo lo vamos a usar en PrototypeRegister
    protected MovilExperience(String planType, String menu, String banners) {
        this.planType = planType;
        this.menu = menu;
        this.banners = banners;
    }


    //Redefinición de clone:
    @Override
    public MovilExperience clone() {
        MovilExperience newExperience = new MovilExperience();
        newExperience.setUsername(this.username);
        newExperience.setPlanType(this.planType);
        newExperience.setMenu(this.planType);
        newExperience.setOffers(this.offers);
        newExperience.setBanners(this.banners);
        newExperience.setLanguage(this.language);
        return newExperience;
    }
}
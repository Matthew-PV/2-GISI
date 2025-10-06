public class NuevoClienteExperience extends UserExperiencePrototype{
    private String username, planType, menu,
            offers, banners, language;

    public NuevoClienteExperience() {}
    // Es protected porque solo lo vamos a usar en PrototypeRegister
    protected NuevoClienteExperience(String planType, String menu, String banners){
        this.planType = planType;
        this.menu = menu;
        this.banners = banners;
    }


    //Redefinición de clone:
    @Override
    public NuevoClienteExperience clone() {
        NuevoClienteExperience newExperience = new NuevoClienteExperience();
        newExperience.setUsername(this.username);
        newExperience.setPlanType(this.planType);
        newExperience.setMenu(this.planType);
        newExperience.setOffers(this.offers);
        newExperience.setBanners(this.banners);
        newExperience.setLanguage(this.language);
        return newExperience;
    }
}
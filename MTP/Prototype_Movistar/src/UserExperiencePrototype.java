abstract class UserExperiencePrototype implements Cloneable {
    private String username, planType, menu,
            offers, banners, language;

    public void setUsername(String username){
        this.username = username;
    }

    public void setPlanType(String planType){
        this.planType = planType;
    }

    public void setMenu(String menu){
        this.menu = menu;
    }

    public void setOffers(String offer){
        this.offers = offer;
    }

    public void setBanners(String banners){
        this.banners = banners;
    }

    public void setLanguage(String language){
        this.language = language;
    }


    @Override
    public String toString(){
        return "Usuario "+username+", con idioma "+language+" y plan "+planType+
                ", con oferta "+offers+" en "+menu+" con "+banners+".";
    }
}
package bwie.example.com.demozhou1105fu.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class CacheBean {
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private String img;
    @Generated(hash = 1264234958)
    public CacheBean(Long id, String title, String img) {
        this.id = id;
        this.title = title;
        this.img = img;
    }
    @Generated(hash = 573552170)
    public CacheBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }

}

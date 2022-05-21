package org.stadium.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Transient;
import org.springframework.security.web.util.UrlUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.net.URLEncoder;

@Entity
@Table(name = "media")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Media extends BaseEntity<Integer> {
    @Lob
    @Column(nullable = false)
    private Byte[] image;
    @Column
    private String name;
    @Transient
    private String uri;


    public String getUri() {
        try {
            return String.format("/api/media/%s", URLEncoder.encode(name, "UTF-8"));
        } catch (Exception exception) {
            return String.format("/api/media/%s", name);
        }
    }
}

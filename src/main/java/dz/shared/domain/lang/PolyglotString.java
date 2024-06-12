package dz.shared.domain.lang;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;
import dz.shared.exception.UnSupportedValueException;
import dz.shared.util.json.JsonSerializable;
import dz.shared.util.json.JsonUtils;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolyglotString implements JsonSerializable {
    //
    private static final long serialVersionUID = -3244779218991188900L;

    @SerializedName(value = "e", alternate = "en")
    private String en;
    @SerializedName(value = "k", alternate = "ko")
    private String ko;
    @SerializedName(value = "z", alternate = "zh")
    private String zh;

    public String genDefaultString() {
        //
        if (ko != null) {
            return ko;
        }
        if (en != null) {
            return en;
        }
        if (zh != null) {
            return zh;
        }
        return null;
    }

    public String genDefaultStringFormat(Object... args) {
        //
        if (this.ko != null) {
            return String.format(this.ko, args);
        } else if (this.en != null) {
            return String.format(this.en, args);
        } else {
            return this.zh != null ? String.format(this.zh, args) : null;
        }
    }

    public String genOrDefaultString(Language language) {
        //
        String value = null;
        switch (language) {
            case Korean:
                value = this.ko;
                break;
            case English:
                value = this.en;
                break;
            case Chinese:
                value = this.zh;
                break;
            default:
                throw new UnSupportedValueException("unsupported language : " + language.name());
        }

        if (StringUtils.isNotEmpty(value)) {
            return value;
        }

        return genDefaultString();
    }

    public static String genOrDefaultString(PolyglotString polyglotString, Language language) {
        //
        return polyglotString == null ? null : polyglotString.genOrDefaultString(language);
    }

    public String genOrDefaultStringFormat(Language language, Object... args) {
        //
        String format = null;
        switch (language) {
            case Korean:
                format = this.ko;
                break;
            case English:
                format = this.en;
                break;
            case Chinese:
                format = this.zh;
                break;
            default:
                throw new UnSupportedValueException("unsupported language : " + language.name());
        }

        return format != null ? String.format(format, args) : this.genDefaultStringFormat(args);
    }

    public String genOrDefaultString(String lang) {
        //
        return genOrDefaultString(Language.valueOf(lang));
    }

    public String genOrDefaultStringFormat(String lang, Object... args) {
        //
        return this.genOrDefaultString(Language.valueOf(lang));
    }

    public void setString(Language language, String value) {
        //
        switch (language) {
            case Korean:
                this.ko = value;
                break;
            case English:
                this.en = value;
                break;
            case Chinese:
                this.zh = value;
                break;
            default:
                throw new UnSupportedValueException("unsupported language : " + language.name());
        }
    }

    public String getString(Language language) {
        //
        switch (language) {
            case Korean:
                return this.ko;
            case English:
                return this.en;
            case Chinese:
                return this.zh;
            default:
                throw new UnSupportedValueException("unsupported language : " + language.name());
        }
    }

    public boolean contains(String value) {
        //
        return getStrings().contains(value);
    }

    public boolean containsAny(String value) {
        //
        return getStrings().stream().anyMatch(each -> each.contains(value));
    }

    public PolyglotString copy() {
        //
        return PolyglotString.builder().en(this.en).ko(this.ko).zh(this.zh).build();
    }

    @JsonIgnore
    public List<String> getStrings() {
        //
        List<String> strings = new ArrayList<>();
        if (this.en != null) {
            strings.add(this.en);
        }

        if (this.ko != null) {
            strings.add(this.ko);
        }

        if (this.zh != null) {
            strings.add(this.zh);
        }

        return strings;
    }

    public static String genDefaultStringIfNotNull(PolyglotString polyglotString) {
        //
        return polyglotString == null ? null : polyglotString.genDefaultString();
    }

    public static PolyglotString newKr(String str) {
        //
        PolyglotString polyglotString = new PolyglotString();
        polyglotString.setKo(str);
        return polyglotString;
    }

    public static PolyglotString newEn(String str) {
        //
        PolyglotString polyglotString = new PolyglotString();
        polyglotString.setEn(str);
        return polyglotString;
    }

    public static PolyglotString newCn(String str) {
        //
        PolyglotString polyglotString = new PolyglotString();
        polyglotString.setZh(str);
        return polyglotString;
    }

    public static String toJson(PolyglotString string) {
        //
        if (string == null) {
            return null;
        }
        return string.toJson();
    }

    public static PolyglotString fromJson(String json) {
        //
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return JsonUtils.fromJson(json, PolyglotString.class);
    }

    public static boolean isNotEmpty(PolyglotString polyglotString) {
        //
        return !isEmpty(polyglotString);
    }

    public static boolean isEmpty(PolyglotString polyglotString) {
        //
        if (polyglotString == null) {
            return true;
        }

        for (String value : polyglotString.getStrings()) {
            if (StringUtils.isNotEmpty(value)) {
                return false;
            }
        }
        return true;
    }

    public static PolyglotString sample() {
        //
        return PolyglotString.builder()
                .en("open")
                .ko("열기")
                .build();
    }

    public String toString() {
        //
        return toJson();
    }

    @Override
    public boolean equals(Object o) {
        //
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolyglotString that = (PolyglotString) o;
        return Objects.equals(en, that.en) &&
                Objects.equals(ko, that.ko) &&
                Objects.equals(zh, that.zh);
    }

    @Override
    public int hashCode() {
        //
        return Objects.hash(en, ko, zh);
    }

    public static void main(String[] args) {
        //
        PolyglotString sample = sample();
        System.out.println(sample);
        System.out.println(PolyglotString.fromJson(sample.toJson()));


    }
}

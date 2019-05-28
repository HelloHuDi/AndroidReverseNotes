package a.i.b.a.c.b.a;

import a.a.ag;
import a.a.i;
import a.a.t;
import a.f.b.j;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum n {
    CLASS("class"),
    ANNOTATION_CLASS("annotation class"),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property"),
    FIELD("field"),
    LOCAL_VARIABLE("local variable"),
    VALUE_PARAMETER("value parameter"),
    CONSTRUCTOR("constructor"),
    FUNCTION("function"),
    PROPERTY_GETTER("getter"),
    PROPERTY_SETTER("setter"),
    TYPE("type usage", false),
    EXPRESSION(ActUtil.EXPRESSION, false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);
    
    private static final Set<n> BgR = null;
    private static final Set<n> BgS = null;
    private static final Map<e, n> BgT = null;
    public static final a BgU = null;
    private static final HashMap<String, n> cag = null;
    private final String description;
    private final boolean isDefault;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private n(String str, boolean z) {
        j.p(str, "description");
        AppMethodBeat.i(119367);
        this.description = str;
        this.isDefault = z;
        AppMethodBeat.o(119367);
    }

    static {
        BgU = new a();
        cag = new HashMap();
        for (n nVar : values()) {
            cag.put(nVar.name(), nVar);
        }
        n[] values = values();
        Collection arrayList = new ArrayList();
        for (n nVar2 : values) {
            if (nVar2.isDefault) {
                arrayList.add(nVar2);
            }
        }
        BgR = t.o((List) arrayList);
        BgS = i.R(values());
        BgT = ag.a(u.I(e.CONSTRUCTOR_PARAMETER, VALUE_PARAMETER), u.I(e.FIELD, FIELD), u.I(e.PROPERTY, PROPERTY), u.I(e.FILE, FILE), u.I(e.PROPERTY_GETTER, PROPERTY_GETTER), u.I(e.PROPERTY_SETTER, PROPERTY_SETTER), u.I(e.RECEIVER, VALUE_PARAMETER), u.I(e.SETTER_PARAMETER, VALUE_PARAMETER), u.I(e.PROPERTY_DELEGATE_FIELD, FIELD));
        AppMethodBeat.o(119366);
    }
}

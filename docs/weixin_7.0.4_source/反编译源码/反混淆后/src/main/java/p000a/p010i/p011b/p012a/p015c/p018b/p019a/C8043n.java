package p000a.p010i.p011b.p012a.p015c.p018b.p019a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000a.C8312u;
import p000a.p001a.C25035t;
import p000a.p001a.C31586ag;
import p000a.p001a.C36913i;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.b.a.n */
public enum C8043n {
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
    
    private static final Set<C8043n> BgR = null;
    private static final Set<C8043n> BgS = null;
    private static final Map<C8039e, C8043n> BgT = null;
    public static final C8044a BgU = null;
    private static final HashMap<String, C8043n> cag = null;
    private final String description;
    private final boolean isDefault;

    /* renamed from: a.i.b.a.c.b.a.n$a */
    public static final class C8044a {
        private C8044a() {
        }

        public /* synthetic */ C8044a(byte b) {
            this();
        }
    }

    private C8043n(String str, boolean z) {
        C25052j.m39376p(str, "description");
        AppMethodBeat.m2504i(119367);
        this.description = str;
        this.isDefault = z;
        AppMethodBeat.m2505o(119367);
    }

    static {
        BgU = new C8044a();
        cag = new HashMap();
        for (C8043n c8043n : C8043n.values()) {
            cag.put(c8043n.name(), c8043n);
        }
        C8043n[] values = C8043n.values();
        Collection arrayList = new ArrayList();
        for (C8043n c8043n2 : values) {
            if (c8043n2.isDefault) {
                arrayList.add(c8043n2);
            }
        }
        BgR = C25035t.m39354o((List) arrayList);
        BgS = C36913i.m61685R(C8043n.values());
        BgT = C31586ag.m51049a(C8312u.m14628I(C8039e.CONSTRUCTOR_PARAMETER, VALUE_PARAMETER), C8312u.m14628I(C8039e.FIELD, FIELD), C8312u.m14628I(C8039e.PROPERTY, PROPERTY), C8312u.m14628I(C8039e.FILE, FILE), C8312u.m14628I(C8039e.PROPERTY_GETTER, PROPERTY_GETTER), C8312u.m14628I(C8039e.PROPERTY_SETTER, PROPERTY_SETTER), C8312u.m14628I(C8039e.RECEIVER, VALUE_PARAMETER), C8312u.m14628I(C8039e.SETTER_PARAMETER, VALUE_PARAMETER), C8312u.m14628I(C8039e.PROPERTY_DELEGATE_FIELD, FIELD));
        AppMethodBeat.m2505o(119366);
    }
}

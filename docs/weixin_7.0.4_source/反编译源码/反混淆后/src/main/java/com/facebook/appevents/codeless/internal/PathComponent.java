package com.facebook.appevents.codeless.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class PathComponent {
    private static final String PATH_CLASS_NAME_KEY = "class_name";
    private static final String PATH_DESCRIPTION_KEY = "description";
    private static final String PATH_HINT_KEY = "hint";
    private static final String PATH_ID_KEY = "id";
    private static final String PATH_INDEX_KEY = "index";
    private static final String PATH_MATCH_BITMASK_KEY = "match_bitmask";
    private static final String PATH_TAG_KEY = "tag";
    private static final String PATH_TEXT_KEY = "text";
    public final String className;
    public final String description;
    public final String hint;
    /* renamed from: id */
    public final int f1029id;
    public final int index;
    public final int matchBitmask;
    public final String tag;
    public final String text;

    public enum MatchBitmaskType {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);
        
        private final int value;

        static {
            AppMethodBeat.m2505o(72104);
        }

        private MatchBitmaskType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    PathComponent(JSONObject jSONObject) {
        AppMethodBeat.m2504i(72105);
        this.className = jSONObject.getString(PATH_CLASS_NAME_KEY);
        this.index = jSONObject.optInt("index", -1);
        this.f1029id = jSONObject.optInt("id");
        this.text = jSONObject.optString(PATH_TEXT_KEY);
        this.tag = jSONObject.optString(PATH_TAG_KEY);
        this.description = jSONObject.optString("description");
        this.hint = jSONObject.optString(PATH_HINT_KEY);
        this.matchBitmask = jSONObject.optInt(PATH_MATCH_BITMASK_KEY);
        AppMethodBeat.m2505o(72105);
    }
}

package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public final class GameRequestContent implements ShareModel {
    public static final Creator<GameRequestContent> CREATOR = new C372201();
    private final ActionType actionType;
    private final String data;
    private final Filters filters;
    private final String message;
    private final String objectId;
    private final List<String> recipients;
    private final List<String> suggestions;
    private final String title;

    public enum Filters {
        APP_USERS,
        APP_NON_USERS;

        static {
            AppMethodBeat.m2505o(97388);
        }
    }

    /* renamed from: com.facebook.share.model.GameRequestContent$1 */
    static class C372201 implements Creator<GameRequestContent> {
        C372201() {
        }

        public final GameRequestContent createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97374);
            GameRequestContent gameRequestContent = new GameRequestContent(parcel);
            AppMethodBeat.m2505o(97374);
            return gameRequestContent;
        }

        public final GameRequestContent[] newArray(int i) {
            return new GameRequestContent[i];
        }
    }

    public enum ActionType {
        SEND,
        ASKFOR,
        TURN;

        static {
            AppMethodBeat.m2505o(97379);
        }
    }

    public static class Builder implements ShareModelBuilder<GameRequestContent, Builder> {
        private ActionType actionType;
        private String data;
        private Filters filters;
        private String message;
        private String objectId;
        private List<String> recipients;
        private List<String> suggestions;
        private String title;

        public Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        public Builder setTo(String str) {
            AppMethodBeat.m2504i(97380);
            if (str != null) {
                this.recipients = Arrays.asList(str.split(","));
            }
            AppMethodBeat.m2505o(97380);
            return this;
        }

        public Builder setRecipients(List<String> list) {
            this.recipients = list;
            return this;
        }

        public Builder setData(String str) {
            this.data = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setActionType(ActionType actionType) {
            this.actionType = actionType;
            return this;
        }

        public Builder setObjectId(String str) {
            this.objectId = str;
            return this;
        }

        public Builder setFilters(Filters filters) {
            this.filters = filters;
            return this;
        }

        public Builder setSuggestions(List<String> list) {
            this.suggestions = list;
            return this;
        }

        public GameRequestContent build() {
            AppMethodBeat.m2504i(97381);
            GameRequestContent gameRequestContent = new GameRequestContent(this, null);
            AppMethodBeat.m2505o(97381);
            return gameRequestContent;
        }

        public Builder readFrom(GameRequestContent gameRequestContent) {
            AppMethodBeat.m2504i(97382);
            if (gameRequestContent == null) {
                AppMethodBeat.m2505o(97382);
                return this;
            }
            this = setMessage(gameRequestContent.getMessage()).setRecipients(gameRequestContent.getRecipients()).setTitle(gameRequestContent.getTitle()).setData(gameRequestContent.getData()).setActionType(gameRequestContent.getActionType()).setObjectId(gameRequestContent.getObjectId()).setFilters(gameRequestContent.getFilters()).setSuggestions(gameRequestContent.getSuggestions());
            AppMethodBeat.m2505o(97382);
            return this;
        }

        /* Access modifiers changed, original: 0000 */
        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.m2504i(97383);
            Builder readFrom = readFrom((GameRequestContent) parcel.readParcelable(GameRequestContent.class.getClassLoader()));
            AppMethodBeat.m2505o(97383);
            return readFrom;
        }
    }

    /* synthetic */ GameRequestContent(Builder builder, C372201 c372201) {
        this(builder);
    }

    private GameRequestContent(Builder builder) {
        AppMethodBeat.m2504i(97389);
        this.message = builder.message;
        this.recipients = builder.recipients;
        this.title = builder.title;
        this.data = builder.data;
        this.actionType = builder.actionType;
        this.objectId = builder.objectId;
        this.filters = builder.filters;
        this.suggestions = builder.suggestions;
        AppMethodBeat.m2505o(97389);
    }

    GameRequestContent(Parcel parcel) {
        AppMethodBeat.m2504i(97390);
        this.message = parcel.readString();
        this.recipients = parcel.createStringArrayList();
        this.title = parcel.readString();
        this.data = parcel.readString();
        this.actionType = (ActionType) parcel.readSerializable();
        this.objectId = parcel.readString();
        this.filters = (Filters) parcel.readSerializable();
        this.suggestions = parcel.createStringArrayList();
        parcel.readStringList(this.suggestions);
        AppMethodBeat.m2505o(97390);
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTo() {
        AppMethodBeat.m2504i(97391);
        if (getRecipients() != null) {
            String join = TextUtils.join(",", getRecipients());
            AppMethodBeat.m2505o(97391);
            return join;
        }
        AppMethodBeat.m2505o(97391);
        return null;
    }

    public final List<String> getRecipients() {
        return this.recipients;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getData() {
        return this.data;
    }

    public final ActionType getActionType() {
        return this.actionType;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final Filters getFilters() {
        return this.filters;
    }

    public final List<String> getSuggestions() {
        return this.suggestions;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(97392);
        parcel.writeString(this.message);
        parcel.writeStringList(this.recipients);
        parcel.writeString(this.title);
        parcel.writeString(this.data);
        parcel.writeSerializable(this.actionType);
        parcel.writeString(this.objectId);
        parcel.writeSerializable(this.filters);
        parcel.writeStringList(this.suggestions);
        AppMethodBeat.m2505o(97392);
    }

    static {
        AppMethodBeat.m2504i(97393);
        AppMethodBeat.m2505o(97393);
    }
}

package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ShareContent<P extends ShareContent, E extends Builder> implements ShareModel {
    private final Uri contentUrl;
    private final ShareHashtag hashtag;
    private final String pageId;
    private final List<String> peopleIds;
    private final String placeId;
    private final String ref;

    public static abstract class Builder<P extends ShareContent, E extends Builder> implements ShareModelBuilder<P, E> {
        private Uri contentUrl;
        private ShareHashtag hashtag;
        private String pageId;
        private List<String> peopleIds;
        private String placeId;
        private String ref;

        public E setContentUrl(Uri uri) {
            this.contentUrl = uri;
            return this;
        }

        public E setPeopleIds(List<String> list) {
            this.peopleIds = list == null ? null : Collections.unmodifiableList(list);
            return this;
        }

        public E setPlaceId(String str) {
            this.placeId = str;
            return this;
        }

        public E setPageId(String str) {
            this.pageId = str;
            return this;
        }

        public E setRef(String str) {
            this.ref = str;
            return this;
        }

        public E setShareHashtag(ShareHashtag shareHashtag) {
            this.hashtag = shareHashtag;
            return this;
        }

        public E readFrom(P p) {
            if (p == null) {
                return this;
            }
            return setContentUrl(p.getContentUrl()).setPeopleIds(p.getPeopleIds()).setPlaceId(p.getPlaceId()).setPageId(p.getPageId()).setRef(p.getRef());
        }
    }

    protected ShareContent(Builder builder) {
        this.contentUrl = builder.contentUrl;
        this.peopleIds = builder.peopleIds;
        this.placeId = builder.placeId;
        this.pageId = builder.pageId;
        this.ref = builder.ref;
        this.hashtag = builder.hashtag;
    }

    protected ShareContent(Parcel parcel) {
        this.contentUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.peopleIds = readUnmodifiableStringList(parcel);
        this.placeId = parcel.readString();
        this.pageId = parcel.readString();
        this.ref = parcel.readString();
        this.hashtag = new com.facebook.share.model.ShareHashtag.Builder().readFrom(parcel).build();
    }

    public Uri getContentUrl() {
        return this.contentUrl;
    }

    public List<String> getPeopleIds() {
        return this.peopleIds;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public String getPageId() {
        return this.pageId;
    }

    public String getRef() {
        return this.ref;
    }

    public ShareHashtag getShareHashtag() {
        return this.hashtag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.contentUrl, 0);
        parcel.writeStringList(this.peopleIds);
        parcel.writeString(this.placeId);
        parcel.writeString(this.pageId);
        parcel.writeString(this.ref);
        parcel.writeParcelable(this.hashtag, 0);
    }

    private List<String> readUnmodifiableStringList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        return arrayList.size() == 0 ? null : Collections.unmodifiableList(arrayList);
    }
}

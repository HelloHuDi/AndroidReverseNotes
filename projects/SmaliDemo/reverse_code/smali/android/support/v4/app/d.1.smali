.class final Landroid/support/v4/app/d;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator<",
        "Landroid/support/v4/app/e;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 159
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/support/v4/app/e;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .line 162
    new-instance v0, Landroid/support/v4/app/e;

    invoke-direct {v0, p1}, Landroid/support/v4/app/e;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 0

    .line 159
    invoke-virtual {p0, p1}, Landroid/support/v4/app/d;->createFromParcel(Landroid/os/Parcel;)Landroid/support/v4/app/e;

    move-result-object p1

    return-object p1
.end method

.method public newArray(I)[Landroid/support/v4/app/e;
    .locals 1
    .param p1, "size"    # I

    .line 167
    new-array v0, p1, [Landroid/support/v4/app/e;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 0

    .line 159
    invoke-virtual {p0, p1}, Landroid/support/v4/app/d;->newArray(I)[Landroid/support/v4/app/e;

    move-result-object p1

    return-object p1
.end method

.class final Landroid/support/v4/app/x;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/y;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator<",
        "Landroid/support/v4/app/y;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 647
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/support/v4/app/y;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .line 650
    new-instance v0, Landroid/support/v4/app/y;

    invoke-direct {v0, p1}, Landroid/support/v4/app/y;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 0

    .line 647
    invoke-virtual {p0, p1}, Landroid/support/v4/app/x;->createFromParcel(Landroid/os/Parcel;)Landroid/support/v4/app/y;

    move-result-object p1

    return-object p1
.end method

.method public newArray(I)[Landroid/support/v4/app/y;
    .locals 1
    .param p1, "size"    # I

    .line 655
    new-array v0, p1, [Landroid/support/v4/app/y;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 0

    .line 647
    invoke-virtual {p0, p1}, Landroid/support/v4/app/x;->newArray(I)[Landroid/support/v4/app/y;

    move-result-object p1

    return-object p1
.end method

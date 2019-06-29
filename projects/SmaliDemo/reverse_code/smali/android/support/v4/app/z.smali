.class final Landroid/support/v4/app/z;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/A;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator<",
        "Landroid/support/v4/app/A;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 130
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/support/v4/app/A;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .line 133
    new-instance v0, Landroid/support/v4/app/A;

    invoke-direct {v0, p1}, Landroid/support/v4/app/A;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 0

    .line 130
    invoke-virtual {p0, p1}, Landroid/support/v4/app/z;->createFromParcel(Landroid/os/Parcel;)Landroid/support/v4/app/A;

    move-result-object p1

    return-object p1
.end method

.method public newArray(I)[Landroid/support/v4/app/A;
    .locals 1
    .param p1, "size"    # I

    .line 138
    new-array v0, p1, [Landroid/support/v4/app/A;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 0

    .line 130
    invoke-virtual {p0, p1}, Landroid/support/v4/app/z;->newArray(I)[Landroid/support/v4/app/A;

    move-result-object p1

    return-object p1
.end method

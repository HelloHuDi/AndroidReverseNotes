.class public abstract La/b/c/g/c;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "La/b/c/g/c;",
            ">;"
        }
    .end annotation
.end field

.field public static final a:La/b/c/g/c;


# instance fields
.field private final b:Landroid/os/Parcelable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 30
    new-instance v0, La/b/c/g/a;

    invoke-direct {v0}, La/b/c/g/a;-><init>()V

    sput-object v0, La/b/c/g/c;->a:La/b/c/g/c;

    .line 88
    new-instance v0, La/b/c/g/b;

    invoke-direct {v0}, La/b/c/g/b;-><init>()V

    sput-object v0, La/b/c/g/c;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    const/4 v0, 0x0

    iput-object v0, p0, La/b/c/g/c;->b:Landroid/os/Parcelable;

    .line 39
    return-void
.end method

.method synthetic constructor <init>(La/b/c/g/a;)V
    .locals 0
    .param p1, "x0"    # La/b/c/g/a;

    .line 29
    invoke-direct {p0}, La/b/c/g/c;-><init>()V

    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V
    .locals 2
    .param p1, "source"    # Landroid/os/Parcel;
    .param p2, "loader"    # Ljava/lang/ClassLoader;

    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    invoke-virtual {p1, p2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    .line 70
    .local v0, "superState":Landroid/os/Parcelable;
    if-eqz v0, :cond_0

    move-object v1, v0

    goto :goto_0

    :cond_0
    sget-object v1, La/b/c/g/c;->a:La/b/c/g/c;

    :goto_0
    iput-object v1, p0, La/b/c/g/c;->b:Landroid/os/Parcelable;

    .line 71
    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcelable;)V
    .locals 2
    .param p1, "superState"    # Landroid/os/Parcelable;

    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    if-eqz p1, :cond_1

    .line 50
    sget-object v0, La/b/c/g/c;->a:La/b/c/g/c;

    if-eq p1, v0, :cond_0

    move-object v0, p1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, La/b/c/g/c;->b:Landroid/os/Parcelable;

    .line 51
    return-void

    .line 48
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "superState must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public final a()Landroid/os/Parcelable;
    .locals 1

    .line 75
    iget-object v0, p0, La/b/c/g/c;->b:Landroid/os/Parcelable;

    return-object v0
.end method

.method public describeContents()I
    .locals 1

    .line 80
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .line 85
    iget-object v0, p0, La/b/c/g/c;->b:Landroid/os/Parcelable;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 86
    return-void
.end method

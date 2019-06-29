.class final Landroid/support/v4/app/A;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Landroid/support/v4/app/A;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field final a:Ljava/lang/String;

.field final b:I

.field final c:Z

.field final d:I

.field final e:I

.field final f:Ljava/lang/String;

.field final g:Z

.field final h:Z

.field final i:Landroid/os/Bundle;

.field final j:Z

.field k:Landroid/os/Bundle;

.field l:Landroid/support/v4/app/i;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 129
    new-instance v0, Landroid/support/v4/app/z;

    invoke-direct {v0}, Landroid/support/v4/app/z;-><init>()V

    sput-object v0, Landroid/support/v4/app/A;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method constructor <init>(Landroid/os/Parcel;)V
    .locals 3
    .param p1, "in"    # Landroid/os/Parcel;

    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/A;->a:Ljava/lang/String;

    .line 58
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/support/v4/app/A;->b:I

    .line 59
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iput-boolean v0, p0, Landroid/support/v4/app/A;->c:Z

    .line 60
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/support/v4/app/A;->d:I

    .line 61
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/support/v4/app/A;->e:I

    .line 62
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/A;->f:Ljava/lang/String;

    .line 63
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    goto :goto_1

    :cond_1
    const/4 v0, 0x0

    :goto_1
    iput-boolean v0, p0, Landroid/support/v4/app/A;->g:Z

    .line 64
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    goto :goto_2

    :cond_2
    const/4 v0, 0x0

    :goto_2
    iput-boolean v0, p0, Landroid/support/v4/app/A;->h:Z

    .line 65
    invoke-virtual {p1}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/A;->i:Landroid/os/Bundle;

    .line 66
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_3

    goto :goto_3

    :cond_3
    const/4 v1, 0x0

    :goto_3
    iput-boolean v1, p0, Landroid/support/v4/app/A;->j:Z

    .line 67
    invoke-virtual {p1}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/A;->k:Landroid/os/Bundle;

    .line 68
    return-void
.end method

.method constructor <init>(Landroid/support/v4/app/i;)V
    .locals 1
    .param p1, "frag"    # Landroid/support/v4/app/i;

    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/A;->a:Ljava/lang/String;

    .line 45
    iget v0, p1, Landroid/support/v4/app/i;->g:I

    iput v0, p0, Landroid/support/v4/app/A;->b:I

    .line 46
    iget-boolean v0, p1, Landroid/support/v4/app/i;->o:Z

    iput-boolean v0, p0, Landroid/support/v4/app/A;->c:Z

    .line 47
    iget v0, p1, Landroid/support/v4/app/i;->z:I

    iput v0, p0, Landroid/support/v4/app/A;->d:I

    .line 48
    iget v0, p1, Landroid/support/v4/app/i;->A:I

    iput v0, p0, Landroid/support/v4/app/A;->e:I

    .line 49
    iget-object v0, p1, Landroid/support/v4/app/i;->B:Ljava/lang/String;

    iput-object v0, p0, Landroid/support/v4/app/A;->f:Ljava/lang/String;

    .line 50
    iget-boolean v0, p1, Landroid/support/v4/app/i;->E:Z

    iput-boolean v0, p0, Landroid/support/v4/app/A;->g:Z

    .line 51
    iget-boolean v0, p1, Landroid/support/v4/app/i;->D:Z

    iput-boolean v0, p0, Landroid/support/v4/app/A;->h:Z

    .line 52
    iget-object v0, p1, Landroid/support/v4/app/i;->i:Landroid/os/Bundle;

    iput-object v0, p0, Landroid/support/v4/app/A;->i:Landroid/os/Bundle;

    .line 53
    iget-boolean v0, p1, Landroid/support/v4/app/i;->C:Z

    iput-boolean v0, p0, Landroid/support/v4/app/A;->j:Z

    .line 54
    return-void
.end method


# virtual methods
.method public a(Landroid/support/v4/app/n;Landroid/support/v4/app/l;Landroid/support/v4/app/i;Landroid/support/v4/app/w;Landroid/arch/lifecycle/s;)Landroid/support/v4/app/i;
    .locals 3
    .param p1, "host"    # Landroid/support/v4/app/n;
    .param p2, "container"    # Landroid/support/v4/app/l;
    .param p3, "parent"    # Landroid/support/v4/app/i;
    .param p4, "childNonConfig"    # Landroid/support/v4/app/w;
    .param p5, "viewModelStore"    # Landroid/arch/lifecycle/s;

    .line 73
    iget-object v0, p0, Landroid/support/v4/app/A;->l:Landroid/support/v4/app/i;

    if-nez v0, :cond_3

    .line 74
    invoke-virtual {p1}, Landroid/support/v4/app/n;->c()Landroid/content/Context;

    move-result-object v0

    .line 75
    .local v0, "context":Landroid/content/Context;
    iget-object v1, p0, Landroid/support/v4/app/A;->i:Landroid/os/Bundle;

    if-eqz v1, :cond_0

    .line 76
    invoke-virtual {v0}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    .line 79
    :cond_0
    if-eqz p2, :cond_1

    .line 80
    iget-object v1, p0, Landroid/support/v4/app/A;->a:Ljava/lang/String;

    iget-object v2, p0, Landroid/support/v4/app/A;->i:Landroid/os/Bundle;

    invoke-virtual {p2, v0, v1, v2}, Landroid/support/v4/app/l;->a(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/i;

    move-result-object v1

    iput-object v1, p0, Landroid/support/v4/app/A;->l:Landroid/support/v4/app/i;

    goto :goto_0

    .line 82
    :cond_1
    iget-object v1, p0, Landroid/support/v4/app/A;->a:Ljava/lang/String;

    iget-object v2, p0, Landroid/support/v4/app/A;->i:Landroid/os/Bundle;

    invoke-static {v0, v1, v2}, Landroid/support/v4/app/i;->a(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/i;

    move-result-object v1

    iput-object v1, p0, Landroid/support/v4/app/A;->l:Landroid/support/v4/app/i;

    .line 85
    :goto_0
    iget-object v1, p0, Landroid/support/v4/app/A;->k:Landroid/os/Bundle;

    if-eqz v1, :cond_2

    .line 86
    invoke-virtual {v0}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    .line 87
    iget-object v1, p0, Landroid/support/v4/app/A;->l:Landroid/support/v4/app/i;

    iget-object v2, p0, Landroid/support/v4/app/A;->k:Landroid/os/Bundle;

    iput-object v2, v1, Landroid/support/v4/app/i;->d:Landroid/os/Bundle;

    .line 89
    :cond_2
    iget-object v1, p0, Landroid/support/v4/app/A;->l:Landroid/support/v4/app/i;

    iget v2, p0, Landroid/support/v4/app/A;->b:I

    invoke-virtual {v1, v2, p3}, Landroid/support/v4/app/i;->a(ILandroid/support/v4/app/i;)V

    .line 90
    iget-object v1, p0, Landroid/support/v4/app/A;->l:Landroid/support/v4/app/i;

    iget-boolean v2, p0, Landroid/support/v4/app/A;->c:Z

    iput-boolean v2, v1, Landroid/support/v4/app/i;->o:Z

    .line 91
    const/4 v2, 0x1

    iput-boolean v2, v1, Landroid/support/v4/app/i;->q:Z

    .line 92
    iget v2, p0, Landroid/support/v4/app/A;->d:I

    iput v2, v1, Landroid/support/v4/app/i;->z:I

    .line 93
    iget v2, p0, Landroid/support/v4/app/A;->e:I

    iput v2, v1, Landroid/support/v4/app/i;->A:I

    .line 94
    iget-object v2, p0, Landroid/support/v4/app/A;->f:Ljava/lang/String;

    iput-object v2, v1, Landroid/support/v4/app/i;->B:Ljava/lang/String;

    .line 95
    iget-boolean v2, p0, Landroid/support/v4/app/A;->g:Z

    iput-boolean v2, v1, Landroid/support/v4/app/i;->E:Z

    .line 96
    iget-boolean v2, p0, Landroid/support/v4/app/A;->h:Z

    iput-boolean v2, v1, Landroid/support/v4/app/i;->D:Z

    .line 97
    iget-boolean v2, p0, Landroid/support/v4/app/A;->j:Z

    iput-boolean v2, v1, Landroid/support/v4/app/i;->C:Z

    .line 98
    iget-object v2, p1, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    iput-object v2, v1, Landroid/support/v4/app/i;->t:Landroid/support/v4/app/v;

    .line 100
    sget-boolean v1, Landroid/support/v4/app/v;->a:Z

    if-eqz v1, :cond_3

    .line 101
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Instantiated fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Landroid/support/v4/app/A;->l:Landroid/support/v4/app/i;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "FragmentManager"

    invoke-static {v2, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 104
    .end local v0    # "context":Landroid/content/Context;
    :cond_3
    iget-object v0, p0, Landroid/support/v4/app/A;->l:Landroid/support/v4/app/i;

    iput-object p4, v0, Landroid/support/v4/app/i;->w:Landroid/support/v4/app/w;

    .line 105
    iput-object p5, v0, Landroid/support/v4/app/i;->x:Landroid/arch/lifecycle/s;

    .line 106
    return-object v0
.end method

.method public describeContents()I
    .locals 1

    .line 111
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .line 116
    iget-object v0, p0, Landroid/support/v4/app/A;->a:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 117
    iget v0, p0, Landroid/support/v4/app/A;->b:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 118
    iget-boolean v0, p0, Landroid/support/v4/app/A;->c:Z

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 119
    iget v0, p0, Landroid/support/v4/app/A;->d:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 120
    iget v0, p0, Landroid/support/v4/app/A;->e:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 121
    iget-object v0, p0, Landroid/support/v4/app/A;->f:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 122
    iget-boolean v0, p0, Landroid/support/v4/app/A;->g:Z

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 123
    iget-boolean v0, p0, Landroid/support/v4/app/A;->h:Z

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 124
    iget-object v0, p0, Landroid/support/v4/app/A;->i:Landroid/os/Bundle;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeBundle(Landroid/os/Bundle;)V

    .line 125
    iget-boolean v0, p0, Landroid/support/v4/app/A;->j:Z

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 126
    iget-object v0, p0, Landroid/support/v4/app/A;->k:Landroid/os/Bundle;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeBundle(Landroid/os/Bundle;)V

    .line 127
    return-void
.end method

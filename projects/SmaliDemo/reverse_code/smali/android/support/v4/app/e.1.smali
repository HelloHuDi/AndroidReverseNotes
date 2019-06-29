.class final Landroid/support/v4/app/e;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Landroid/support/v4/app/e;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field final a:[I

.field final b:I

.field final c:I

.field final d:Ljava/lang/String;

.field final e:I

.field final f:I

.field final g:Ljava/lang/CharSequence;

.field final h:I

.field final i:Ljava/lang/CharSequence;

.field final j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final l:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 158
    new-instance v0, Landroid/support/v4/app/d;

    invoke-direct {v0}, Landroid/support/v4/app/d;-><init>()V

    sput-object v0, Landroid/support/v4/app/e;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 80
    invoke-virtual {p1}, Landroid/os/Parcel;->createIntArray()[I

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/e;->a:[I

    .line 81
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/support/v4/app/e;->b:I

    .line 82
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/support/v4/app/e;->c:I

    .line 83
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/e;->d:Ljava/lang/String;

    .line 84
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/support/v4/app/e;->e:I

    .line 85
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/support/v4/app/e;->f:I

    .line 86
    sget-object v0, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    iput-object v0, p0, Landroid/support/v4/app/e;->g:Ljava/lang/CharSequence;

    .line 87
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/support/v4/app/e;->h:I

    .line 88
    sget-object v0, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    iput-object v0, p0, Landroid/support/v4/app/e;->i:Ljava/lang/CharSequence;

    .line 89
    invoke-virtual {p1}, Landroid/os/Parcel;->createStringArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/e;->j:Ljava/util/ArrayList;

    .line 90
    invoke-virtual {p1}, Landroid/os/Parcel;->createStringArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/e;->k:Ljava/util/ArrayList;

    .line 91
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iput-boolean v0, p0, Landroid/support/v4/app/e;->l:Z

    .line 92
    return-void
.end method

.method public constructor <init>(Landroid/support/v4/app/c;)V
    .locals 7
    .param p1, "bse"    # Landroid/support/v4/app/c;

    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iget-object v0, p1, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 50
    .local v0, "numOps":I
    mul-int/lit8 v1, v0, 0x6

    new-array v1, v1, [I

    iput-object v1, p0, Landroid/support/v4/app/e;->a:[I

    .line 52
    iget-boolean v1, p1, Landroid/support/v4/app/c;->i:Z

    if-eqz v1, :cond_2

    .line 56
    const/4 v1, 0x0

    .line 57
    .local v1, "pos":I
    const/4 v2, 0x0

    .local v2, "opNum":I
    :goto_0
    if-ge v2, v0, :cond_1

    .line 58
    iget-object v3, p1, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v4/app/c$a;

    .line 59
    .local v3, "op":Landroid/support/v4/app/c$a;
    iget-object v4, p0, Landroid/support/v4/app/e;->a:[I

    add-int/lit8 v5, v1, 0x1

    .end local v1    # "pos":I
    .local v5, "pos":I
    iget v6, v3, Landroid/support/v4/app/c$a;->a:I

    aput v6, v4, v1

    .line 60
    add-int/lit8 v1, v5, 0x1

    .end local v5    # "pos":I
    .restart local v1    # "pos":I
    iget-object v6, v3, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    if-eqz v6, :cond_0

    iget v6, v6, Landroid/support/v4/app/i;->g:I

    goto :goto_1

    :cond_0
    const/4 v6, -0x1

    :goto_1
    aput v6, v4, v5

    .line 61
    iget-object v4, p0, Landroid/support/v4/app/e;->a:[I

    add-int/lit8 v5, v1, 0x1

    .end local v1    # "pos":I
    .restart local v5    # "pos":I
    iget v6, v3, Landroid/support/v4/app/c$a;->c:I

    aput v6, v4, v1

    .line 62
    add-int/lit8 v1, v5, 0x1

    .end local v5    # "pos":I
    .restart local v1    # "pos":I
    iget v6, v3, Landroid/support/v4/app/c$a;->d:I

    aput v6, v4, v5

    .line 63
    add-int/lit8 v5, v1, 0x1

    .end local v1    # "pos":I
    .restart local v5    # "pos":I
    iget v6, v3, Landroid/support/v4/app/c$a;->e:I

    aput v6, v4, v1

    .line 64
    add-int/lit8 v1, v5, 0x1

    .end local v5    # "pos":I
    .restart local v1    # "pos":I
    iget v6, v3, Landroid/support/v4/app/c$a;->f:I

    aput v6, v4, v5

    .line 57
    .end local v3    # "op":Landroid/support/v4/app/c$a;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 66
    .end local v2    # "opNum":I
    :cond_1
    iget v2, p1, Landroid/support/v4/app/c;->g:I

    iput v2, p0, Landroid/support/v4/app/e;->b:I

    .line 67
    iget v2, p1, Landroid/support/v4/app/c;->h:I

    iput v2, p0, Landroid/support/v4/app/e;->c:I

    .line 68
    iget-object v2, p1, Landroid/support/v4/app/c;->k:Ljava/lang/String;

    iput-object v2, p0, Landroid/support/v4/app/e;->d:Ljava/lang/String;

    .line 69
    iget v2, p1, Landroid/support/v4/app/c;->m:I

    iput v2, p0, Landroid/support/v4/app/e;->e:I

    .line 70
    iget v2, p1, Landroid/support/v4/app/c;->n:I

    iput v2, p0, Landroid/support/v4/app/e;->f:I

    .line 71
    iget-object v2, p1, Landroid/support/v4/app/c;->o:Ljava/lang/CharSequence;

    iput-object v2, p0, Landroid/support/v4/app/e;->g:Ljava/lang/CharSequence;

    .line 72
    iget v2, p1, Landroid/support/v4/app/c;->p:I

    iput v2, p0, Landroid/support/v4/app/e;->h:I

    .line 73
    iget-object v2, p1, Landroid/support/v4/app/c;->q:Ljava/lang/CharSequence;

    iput-object v2, p0, Landroid/support/v4/app/e;->i:Ljava/lang/CharSequence;

    .line 74
    iget-object v2, p1, Landroid/support/v4/app/c;->r:Ljava/util/ArrayList;

    iput-object v2, p0, Landroid/support/v4/app/e;->j:Ljava/util/ArrayList;

    .line 75
    iget-object v2, p1, Landroid/support/v4/app/c;->s:Ljava/util/ArrayList;

    iput-object v2, p0, Landroid/support/v4/app/e;->k:Ljava/util/ArrayList;

    .line 76
    iget-boolean v2, p1, Landroid/support/v4/app/c;->t:Z

    iput-boolean v2, p0, Landroid/support/v4/app/e;->l:Z

    .line 77
    return-void

    .line 53
    .end local v1    # "pos":I
    :cond_2
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Not on back stack"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    goto :goto_3

    :goto_2
    throw v1

    :goto_3
    goto :goto_2
.end method


# virtual methods
.method public a(Landroid/support/v4/app/v;)Landroid/support/v4/app/c;
    .locals 7
    .param p1, "fm"    # Landroid/support/v4/app/v;

    .line 95
    new-instance v0, Landroid/support/v4/app/c;

    invoke-direct {v0, p1}, Landroid/support/v4/app/c;-><init>(Landroid/support/v4/app/v;)V

    .line 96
    .local v0, "bse":Landroid/support/v4/app/c;
    const/4 v1, 0x0

    .line 97
    .local v1, "pos":I
    const/4 v2, 0x0

    .line 98
    .local v2, "num":I
    :goto_0
    iget-object v3, p0, Landroid/support/v4/app/e;->a:[I

    array-length v3, v3

    if-ge v1, v3, :cond_2

    .line 99
    new-instance v3, Landroid/support/v4/app/c$a;

    invoke-direct {v3}, Landroid/support/v4/app/c$a;-><init>()V

    .line 100
    .local v3, "op":Landroid/support/v4/app/c$a;
    iget-object v4, p0, Landroid/support/v4/app/e;->a:[I

    add-int/lit8 v5, v1, 0x1

    .end local v1    # "pos":I
    .local v5, "pos":I
    aget v1, v4, v1

    iput v1, v3, Landroid/support/v4/app/c$a;->a:I

    .line 101
    sget-boolean v1, Landroid/support/v4/app/v;->a:Z

    if-eqz v1, :cond_0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Instantiate "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v4, " op #"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v4, " base fragment #"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v4, p0, Landroid/support/v4/app/e;->a:[I

    aget v4, v4, v5

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v4, "FragmentManager"

    invoke-static {v4, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 103
    :cond_0
    iget-object v1, p0, Landroid/support/v4/app/e;->a:[I

    add-int/lit8 v4, v5, 0x1

    .end local v5    # "pos":I
    .local v4, "pos":I
    aget v1, v1, v5

    .line 104
    .local v1, "findex":I
    if-ltz v1, :cond_1

    .line 105
    iget-object v5, p1, Landroid/support/v4/app/v;->k:Landroid/util/SparseArray;

    invoke-virtual {v5, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/support/v4/app/i;

    .line 106
    .local v5, "f":Landroid/support/v4/app/i;
    iput-object v5, v3, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    .line 107
    .end local v5    # "f":Landroid/support/v4/app/i;
    goto :goto_1

    .line 108
    :cond_1
    const/4 v5, 0x0

    iput-object v5, v3, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    .line 110
    :goto_1
    iget-object v5, p0, Landroid/support/v4/app/e;->a:[I

    add-int/lit8 v6, v4, 0x1

    .end local v4    # "pos":I
    .local v6, "pos":I
    aget v4, v5, v4

    iput v4, v3, Landroid/support/v4/app/c$a;->c:I

    .line 111
    add-int/lit8 v4, v6, 0x1

    .end local v6    # "pos":I
    .restart local v4    # "pos":I
    aget v6, v5, v6

    iput v6, v3, Landroid/support/v4/app/c$a;->d:I

    .line 112
    add-int/lit8 v6, v4, 0x1

    .end local v4    # "pos":I
    .restart local v6    # "pos":I
    aget v4, v5, v4

    iput v4, v3, Landroid/support/v4/app/c$a;->e:I

    .line 113
    add-int/lit8 v4, v6, 0x1

    .end local v6    # "pos":I
    .restart local v4    # "pos":I
    aget v5, v5, v6

    iput v5, v3, Landroid/support/v4/app/c$a;->f:I

    .line 114
    iget v5, v3, Landroid/support/v4/app/c$a;->c:I

    iput v5, v0, Landroid/support/v4/app/c;->c:I

    .line 115
    iget v5, v3, Landroid/support/v4/app/c$a;->d:I

    iput v5, v0, Landroid/support/v4/app/c;->d:I

    .line 116
    iget v5, v3, Landroid/support/v4/app/c$a;->e:I

    iput v5, v0, Landroid/support/v4/app/c;->e:I

    .line 117
    iget v5, v3, Landroid/support/v4/app/c$a;->f:I

    iput v5, v0, Landroid/support/v4/app/c;->f:I

    .line 118
    invoke-virtual {v0, v3}, Landroid/support/v4/app/c;->a(Landroid/support/v4/app/c$a;)V

    .line 119
    nop

    .end local v1    # "findex":I
    .end local v3    # "op":Landroid/support/v4/app/c$a;
    add-int/lit8 v2, v2, 0x1

    .line 120
    move v1, v4

    goto/16 :goto_0

    .line 121
    .end local v4    # "pos":I
    .local v1, "pos":I
    :cond_2
    iget v3, p0, Landroid/support/v4/app/e;->b:I

    iput v3, v0, Landroid/support/v4/app/c;->g:I

    .line 122
    iget v3, p0, Landroid/support/v4/app/e;->c:I

    iput v3, v0, Landroid/support/v4/app/c;->h:I

    .line 123
    iget-object v3, p0, Landroid/support/v4/app/e;->d:Ljava/lang/String;

    iput-object v3, v0, Landroid/support/v4/app/c;->k:Ljava/lang/String;

    .line 124
    iget v3, p0, Landroid/support/v4/app/e;->e:I

    iput v3, v0, Landroid/support/v4/app/c;->m:I

    .line 125
    const/4 v3, 0x1

    iput-boolean v3, v0, Landroid/support/v4/app/c;->i:Z

    .line 126
    iget v4, p0, Landroid/support/v4/app/e;->f:I

    iput v4, v0, Landroid/support/v4/app/c;->n:I

    .line 127
    iget-object v4, p0, Landroid/support/v4/app/e;->g:Ljava/lang/CharSequence;

    iput-object v4, v0, Landroid/support/v4/app/c;->o:Ljava/lang/CharSequence;

    .line 128
    iget v4, p0, Landroid/support/v4/app/e;->h:I

    iput v4, v0, Landroid/support/v4/app/c;->p:I

    .line 129
    iget-object v4, p0, Landroid/support/v4/app/e;->i:Ljava/lang/CharSequence;

    iput-object v4, v0, Landroid/support/v4/app/c;->q:Ljava/lang/CharSequence;

    .line 130
    iget-object v4, p0, Landroid/support/v4/app/e;->j:Ljava/util/ArrayList;

    iput-object v4, v0, Landroid/support/v4/app/c;->r:Ljava/util/ArrayList;

    .line 131
    iget-object v4, p0, Landroid/support/v4/app/e;->k:Ljava/util/ArrayList;

    iput-object v4, v0, Landroid/support/v4/app/c;->s:Ljava/util/ArrayList;

    .line 132
    iget-boolean v4, p0, Landroid/support/v4/app/e;->l:Z

    iput-boolean v4, v0, Landroid/support/v4/app/c;->t:Z

    .line 133
    invoke-virtual {v0, v3}, Landroid/support/v4/app/c;->a(I)V

    .line 134
    return-object v0
.end method

.method public describeContents()I
    .locals 1

    .line 139
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .line 144
    iget-object v0, p0, Landroid/support/v4/app/e;->a:[I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeIntArray([I)V

    .line 145
    iget v0, p0, Landroid/support/v4/app/e;->b:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 146
    iget v0, p0, Landroid/support/v4/app/e;->c:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 147
    iget-object v0, p0, Landroid/support/v4/app/e;->d:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 148
    iget v0, p0, Landroid/support/v4/app/e;->e:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 149
    iget v0, p0, Landroid/support/v4/app/e;->f:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 150
    iget-object v0, p0, Landroid/support/v4/app/e;->g:Ljava/lang/CharSequence;

    const/4 v1, 0x0

    invoke-static {v0, p1, v1}, Landroid/text/TextUtils;->writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V

    .line 151
    iget v0, p0, Landroid/support/v4/app/e;->h:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 152
    iget-object v0, p0, Landroid/support/v4/app/e;->i:Ljava/lang/CharSequence;

    invoke-static {v0, p1, v1}, Landroid/text/TextUtils;->writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V

    .line 153
    iget-object v0, p0, Landroid/support/v4/app/e;->j:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeStringList(Ljava/util/List;)V

    .line 154
    iget-object v0, p0, Landroid/support/v4/app/e;->k:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeStringList(Ljava/util/List;)V

    .line 155
    iget-boolean v0, p0, Landroid/support/v4/app/e;->l:Z

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 156
    return-void
.end method

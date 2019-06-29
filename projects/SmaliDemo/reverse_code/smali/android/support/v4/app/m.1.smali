.class public Landroid/support/v4/app/m;
.super Ljava/lang/Object;
.source ""


# instance fields
.field private final a:Landroid/support/v4/app/n;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/app/n<",
            "*>;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Landroid/support/v4/app/n;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/app/n<",
            "*>;)V"
        }
    .end annotation

    .line 52
    .local p1, "callbacks":Landroid/support/v4/app/n;, "Landroid/support/v4/app/FragmentHostCallback<*>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iput-object p1, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    .line 54
    return-void
.end method

.method public static a(Landroid/support/v4/app/n;)Landroid/support/v4/app/m;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/app/n<",
            "*>;)",
            "Landroid/support/v4/app/m;"
        }
    .end annotation

    .line 49
    .local p0, "callbacks":Landroid/support/v4/app/n;, "Landroid/support/v4/app/FragmentHostCallback<*>;"
    new-instance v0, Landroid/support/v4/app/m;

    invoke-direct {v0, p0}, Landroid/support/v4/app/m;-><init>(Landroid/support/v4/app/n;)V

    return-object v0
.end method


# virtual methods
.method public a(Ljava/lang/String;)Landroid/support/v4/app/i;
    .locals 1
    .param p1, "who"    # Ljava/lang/String;

    .line 82
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->b(Ljava/lang/String;)Landroid/support/v4/app/i;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1
    .param p1, "parent"    # Landroid/view/View;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "attrs"    # Landroid/util/AttributeSet;

    .line 120
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/support/v4/app/v;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public a()V
    .locals 1

    .line 201
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->d()V

    .line 202
    return-void
.end method

.method public a(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .line 307
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->a(Landroid/content/res/Configuration;)V

    .line 308
    return-void
.end method

.method public a(Landroid/os/Parcelable;Landroid/support/v4/app/w;)V
    .locals 1
    .param p1, "state"    # Landroid/os/Parcelable;
    .param p2, "nonConfig"    # Landroid/support/v4/app/w;

    .line 158
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0, p1, p2}, Landroid/support/v4/app/v;->a(Landroid/os/Parcelable;Landroid/support/v4/app/w;)V

    .line 159
    return-void
.end method

.method public a(Landroid/support/v4/app/i;)V
    .locals 2
    .param p1, "parent"    # Landroid/support/v4/app/i;

    .line 104
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v1, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v1, v0, v0, p1}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/n;Landroid/support/v4/app/l;Landroid/support/v4/app/i;)V

    .line 106
    return-void
.end method

.method public a(Landroid/view/Menu;)V
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .line 380
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->a(Landroid/view/Menu;)V

    .line 381
    return-void
.end method

.method public a(Z)V
    .locals 1
    .param p1, "isInMultiWindowMode"    # Z

    .line 285
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->a(Z)V

    .line 286
    return-void
.end method

.method public a(Landroid/view/Menu;Landroid/view/MenuInflater;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .line 331
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0, p1, p2}, Landroid/support/v4/app/v;->a(Landroid/view/Menu;Landroid/view/MenuInflater;)Z

    move-result v0

    return v0
.end method

.method public a(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .line 369
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->a(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public b()V
    .locals 1

    .line 190
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->e()V

    .line 191
    return-void
.end method

.method public b(Z)V
    .locals 1
    .param p1, "isInPictureInPictureMode"    # Z

    .line 296
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->b(Z)V

    .line 297
    return-void
.end method

.method public b(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .line 343
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->b(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public b(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .line 356
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->b(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public c()V
    .locals 1

    .line 274
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->f()V

    .line 275
    return-void
.end method

.method public d()V
    .locals 1

    .line 319
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->h()V

    .line 320
    return-void
.end method

.method public e()V
    .locals 1

    .line 234
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->i()V

    .line 235
    return-void
.end method

.method public f()V
    .locals 1

    .line 223
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->j()V

    .line 224
    return-void
.end method

.method public g()V
    .locals 1

    .line 212
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->k()V

    .line 213
    return-void
.end method

.method public h()V
    .locals 1

    .line 245
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->l()V

    .line 246
    return-void
.end method

.method public i()Z
    .locals 1

    .line 391
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->n()Z

    move-result v0

    return v0
.end method

.method public j()Landroid/support/v4/app/o;
    .locals 1

    .line 60
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    invoke-virtual {v0}, Landroid/support/v4/app/n;->d()Landroid/support/v4/app/v;

    move-result-object v0

    return-object v0
.end method

.method public k()V
    .locals 1

    .line 127
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->q()V

    .line 128
    return-void
.end method

.method public l()Landroid/support/v4/app/w;
    .locals 1

    .line 179
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->s()Landroid/support/v4/app/w;

    move-result-object v0

    return-object v0
.end method

.method public m()Landroid/os/Parcelable;
    .locals 1

    .line 134
    iget-object v0, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/n;

    iget-object v0, v0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->t()Landroid/os/Parcelable;

    move-result-object v0

    return-object v0
.end method

.class public La/b/d/d/f$a;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/d/d/b$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/d/d/f;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
.end annotation


# instance fields
.field final a:Landroid/view/ActionMode$Callback;

.field final b:Landroid/content/Context;

.field final c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "La/b/d/d/f;",
            ">;"
        }
    .end annotation
.end field

.field final d:La/b/c/f/m;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/f/m<",
            "Landroid/view/Menu;",
            "Landroid/view/Menu;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/view/ActionMode$Callback;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "supportCallback"    # Landroid/view/ActionMode$Callback;

    .line 149
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 150
    iput-object p1, p0, La/b/d/d/f$a;->b:Landroid/content/Context;

    .line 151
    iput-object p2, p0, La/b/d/d/f$a;->a:Landroid/view/ActionMode$Callback;

    .line 152
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, La/b/d/d/f$a;->c:Ljava/util/ArrayList;

    .line 153
    new-instance v0, La/b/c/f/m;

    invoke-direct {v0}, La/b/c/f/m;-><init>()V

    iput-object v0, p0, La/b/d/d/f$a;->d:La/b/c/f/m;

    .line 154
    return-void
.end method

.method private a(Landroid/view/Menu;)Landroid/view/Menu;
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;

    .line 181
    iget-object v0, p0, La/b/d/d/f$a;->d:La/b/c/f/m;

    invoke-virtual {v0, p1}, La/b/c/f/m;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/Menu;

    .line 182
    .local v0, "wrapper":Landroid/view/Menu;
    if-nez v0, :cond_0

    .line 183
    iget-object v1, p0, La/b/d/d/f$a;->b:Landroid/content/Context;

    move-object v2, p1

    check-cast v2, La/b/c/c/a/a;

    invoke-static {v1, v2}, Landroid/support/v7/view/menu/x;->a(Landroid/content/Context;La/b/c/c/a/a;)Landroid/view/Menu;

    move-result-object v0

    .line 184
    iget-object v1, p0, La/b/d/d/f$a;->d:La/b/c/f/m;

    invoke-virtual {v1, p1, v0}, La/b/c/f/m;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 186
    :cond_0
    return-object v0
.end method


# virtual methods
.method public a(La/b/d/d/b;)V
    .locals 2
    .param p1, "mode"    # La/b/d/d/b;

    .line 177
    iget-object v0, p0, La/b/d/d/f$a;->a:Landroid/view/ActionMode$Callback;

    invoke-virtual {p0, p1}, La/b/d/d/f$a;->b(La/b/d/d/b;)Landroid/view/ActionMode;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/ActionMode$Callback;->onDestroyActionMode(Landroid/view/ActionMode;)V

    .line 178
    return-void
.end method

.method public a(La/b/d/d/b;Landroid/view/Menu;)Z
    .locals 3
    .param p1, "mode"    # La/b/d/d/b;
    .param p2, "menu"    # Landroid/view/Menu;

    .line 158
    iget-object v0, p0, La/b/d/d/f$a;->a:Landroid/view/ActionMode$Callback;

    invoke-virtual {p0, p1}, La/b/d/d/f$a;->b(La/b/d/d/b;)Landroid/view/ActionMode;

    move-result-object v1

    .line 159
    invoke-direct {p0, p2}, La/b/d/d/f$a;->a(Landroid/view/Menu;)Landroid/view/Menu;

    move-result-object v2

    .line 158
    invoke-interface {v0, v1, v2}, Landroid/view/ActionMode$Callback;->onCreateActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public a(La/b/d/d/b;Landroid/view/MenuItem;)Z
    .locals 4
    .param p1, "mode"    # La/b/d/d/b;
    .param p2, "item"    # Landroid/view/MenuItem;

    .line 171
    iget-object v0, p0, La/b/d/d/f$a;->a:Landroid/view/ActionMode$Callback;

    invoke-virtual {p0, p1}, La/b/d/d/f$a;->b(La/b/d/d/b;)Landroid/view/ActionMode;

    move-result-object v1

    iget-object v2, p0, La/b/d/d/f$a;->b:Landroid/content/Context;

    move-object v3, p2

    check-cast v3, La/b/c/c/a/b;

    .line 172
    invoke-static {v2, v3}, Landroid/support/v7/view/menu/x;->a(Landroid/content/Context;La/b/c/c/a/b;)Landroid/view/MenuItem;

    move-result-object v2

    .line 171
    invoke-interface {v0, v1, v2}, Landroid/view/ActionMode$Callback;->onActionItemClicked(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public b(La/b/d/d/b;)Landroid/view/ActionMode;
    .locals 4
    .param p1, "mode"    # La/b/d/d/b;

    .line 191
    const/4 v0, 0x0

    .local v0, "i":I
    iget-object v1, p0, La/b/d/d/f$a;->c:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    .local v1, "count":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 192
    iget-object v2, p0, La/b/d/d/f$a;->c:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, La/b/d/d/f;

    .line 193
    .local v2, "wrapper":La/b/d/d/f;
    if-eqz v2, :cond_0

    iget-object v3, v2, La/b/d/d/f;->b:La/b/d/d/b;

    if-ne v3, p1, :cond_0

    .line 195
    return-object v2

    .line 191
    .end local v2    # "wrapper":La/b/d/d/f;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 201
    .end local v0    # "i":I
    .end local v1    # "count":I
    :cond_1
    new-instance v0, La/b/d/d/f;

    iget-object v1, p0, La/b/d/d/f$a;->b:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, La/b/d/d/f;-><init>(Landroid/content/Context;La/b/d/d/b;)V

    .line 202
    .local v0, "wrapper":La/b/d/d/f;
    iget-object v1, p0, La/b/d/d/f$a;->c:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 203
    return-object v0
.end method

.method public b(La/b/d/d/b;Landroid/view/Menu;)Z
    .locals 3
    .param p1, "mode"    # La/b/d/d/b;
    .param p2, "menu"    # Landroid/view/Menu;

    .line 164
    iget-object v0, p0, La/b/d/d/f$a;->a:Landroid/view/ActionMode$Callback;

    invoke-virtual {p0, p1}, La/b/d/d/f$a;->b(La/b/d/d/b;)Landroid/view/ActionMode;

    move-result-object v1

    .line 165
    invoke-direct {p0, p2}, La/b/d/d/f$a;->a(Landroid/view/Menu;)Landroid/view/Menu;

    move-result-object v2

    .line 164
    invoke-interface {v0, v1, v2}, Landroid/view/ActionMode$Callback;->onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

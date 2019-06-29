.class Landroid/support/v7/view/menu/j$a;
.super Landroid/widget/BaseAdapter;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/view/menu/j;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "a"
.end annotation


# instance fields
.field private a:I

.field final synthetic b:Landroid/support/v7/view/menu/j;


# direct methods
.method public constructor <init>(Landroid/support/v7/view/menu/j;)V
    .locals 0

    .line 234
    iput-object p1, p0, Landroid/support/v7/view/menu/j$a;->b:Landroid/support/v7/view/menu/j;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 232
    const/4 p1, -0x1

    iput p1, p0, Landroid/support/v7/view/menu/j$a;->a:I

    .line 235
    invoke-virtual {p0}, Landroid/support/v7/view/menu/j$a;->a()V

    .line 236
    return-void
.end method


# virtual methods
.method a()V
    .locals 5

    .line 277
    iget-object v0, p0, Landroid/support/v7/view/menu/j$a;->b:Landroid/support/v7/view/menu/j;

    iget-object v0, v0, Landroid/support/v7/view/menu/j;->c:Landroid/support/v7/view/menu/l;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->f()Landroid/support/v7/view/menu/p;

    move-result-object v0

    .line 278
    .local v0, "expandedItem":Landroid/support/v7/view/menu/p;
    if-eqz v0, :cond_1

    .line 279
    iget-object v1, p0, Landroid/support/v7/view/menu/j$a;->b:Landroid/support/v7/view/menu/j;

    iget-object v1, v1, Landroid/support/v7/view/menu/j;->c:Landroid/support/v7/view/menu/l;

    invoke-virtual {v1}, Landroid/support/v7/view/menu/l;->j()Ljava/util/ArrayList;

    move-result-object v1

    .line 280
    .local v1, "items":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 281
    .local v2, "count":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v2, :cond_1

    .line 282
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/support/v7/view/menu/p;

    .line 283
    .local v4, "item":Landroid/support/v7/view/menu/p;
    if-ne v4, v0, :cond_0

    .line 284
    iput v3, p0, Landroid/support/v7/view/menu/j$a;->a:I

    .line 285
    return-void

    .line 281
    .end local v4    # "item":Landroid/support/v7/view/menu/p;
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 289
    .end local v1    # "items":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .end local v2    # "count":I
    .end local v3    # "i":I
    :cond_1
    const/4 v1, -0x1

    iput v1, p0, Landroid/support/v7/view/menu/j$a;->a:I

    .line 290
    return-void
.end method

.method public getCount()I
    .locals 3

    .line 240
    iget-object v0, p0, Landroid/support/v7/view/menu/j$a;->b:Landroid/support/v7/view/menu/j;

    iget-object v0, v0, Landroid/support/v7/view/menu/j;->c:Landroid/support/v7/view/menu/l;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->j()Ljava/util/ArrayList;

    move-result-object v0

    .line 241
    .local v0, "items":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    iget-object v2, p0, Landroid/support/v7/view/menu/j$a;->b:Landroid/support/v7/view/menu/j;

    iget v2, v2, Landroid/support/v7/view/menu/j;->e:I

    sub-int/2addr v1, v2

    .line 242
    .local v1, "count":I
    iget v2, p0, Landroid/support/v7/view/menu/j$a;->a:I

    if-gez v2, :cond_0

    .line 243
    return v1

    .line 245
    :cond_0
    add-int/lit8 v2, v1, -0x1

    return v2
.end method

.method public getItem(I)Landroid/support/v7/view/menu/p;
    .locals 2
    .param p1, "position"    # I

    .line 250
    iget-object v0, p0, Landroid/support/v7/view/menu/j$a;->b:Landroid/support/v7/view/menu/j;

    iget-object v0, v0, Landroid/support/v7/view/menu/j;->c:Landroid/support/v7/view/menu/l;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->j()Ljava/util/ArrayList;

    move-result-object v0

    .line 251
    .local v0, "items":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    iget-object v1, p0, Landroid/support/v7/view/menu/j$a;->b:Landroid/support/v7/view/menu/j;

    iget v1, v1, Landroid/support/v7/view/menu/j;->e:I

    add-int/2addr p1, v1

    .line 252
    iget v1, p0, Landroid/support/v7/view/menu/j$a;->a:I

    if-ltz v1, :cond_0

    if-lt p1, v1, :cond_0

    .line 253
    add-int/lit8 p1, p1, 0x1

    .line 255
    :cond_0
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v7/view/menu/p;

    return-object v1
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 0

    .line 231
    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/j$a;->getItem(I)Landroid/support/v7/view/menu/p;

    move-result-object p1

    return-object p1
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .line 262
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .line 267
    const/4 v0, 0x0

    if-nez p2, :cond_0

    .line 268
    iget-object v1, p0, Landroid/support/v7/view/menu/j$a;->b:Landroid/support/v7/view/menu/j;

    iget-object v2, v1, Landroid/support/v7/view/menu/j;->b:Landroid/view/LayoutInflater;

    iget v1, v1, Landroid/support/v7/view/menu/j;->g:I

    invoke-virtual {v2, v1, p3, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 271
    :cond_0
    move-object v1, p2

    check-cast v1, Landroid/support/v7/view/menu/w$a;

    .line 272
    .local v1, "itemView":Landroid/support/v7/view/menu/w$a;
    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/j$a;->getItem(I)Landroid/support/v7/view/menu/p;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Landroid/support/v7/view/menu/w$a;->a(Landroid/support/v7/view/menu/p;I)V

    .line 273
    return-object p2
.end method

.method public notifyDataSetChanged()V
    .locals 0

    .line 294
    invoke-virtual {p0}, Landroid/support/v7/view/menu/j$a;->a()V

    .line 295
    invoke-super {p0}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 296
    return-void
.end method

.class Landroid/support/v7/widget/g;
.super Landroid/support/v7/view/menu/b;
.source ""

# interfaces
.implements La/b/c/g/e$a;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/widget/g$b;,
        Landroid/support/v7/widget/g$c;,
        Landroid/support/v7/widget/g$f;,
        Landroid/support/v7/widget/g$a;,
        Landroid/support/v7/widget/g$e;,
        Landroid/support/v7/widget/g$d;
    }
.end annotation


# instance fields
.field A:Landroid/support/v7/widget/g$a;

.field B:Landroid/support/v7/widget/g$c;

.field private C:Landroid/support/v7/widget/g$b;

.field final D:Landroid/support/v7/widget/g$f;

.field E:I

.field k:Landroid/support/v7/widget/g$d;

.field private l:Landroid/graphics/drawable/Drawable;

.field private m:Z

.field private n:Z

.field private o:Z

.field private p:I

.field private q:I

.field private r:I

.field private s:Z

.field private t:Z

.field private u:Z

.field private v:Z

.field private w:I

.field private final x:Landroid/util/SparseBooleanArray;

.field private y:Landroid/view/View;

.field z:Landroid/support/v7/widget/g$e;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .line 88
    sget v0, La/b/d/a/g;->abc_action_menu_layout:I

    sget v1, La/b/d/a/g;->abc_action_menu_item_layout:I

    invoke-direct {p0, p1, v0, v1}, Landroid/support/v7/view/menu/b;-><init>(Landroid/content/Context;II)V

    .line 74
    new-instance v0, Landroid/util/SparseBooleanArray;

    invoke-direct {v0}, Landroid/util/SparseBooleanArray;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/g;->x:Landroid/util/SparseBooleanArray;

    .line 84
    new-instance v0, Landroid/support/v7/widget/g$f;

    invoke-direct {v0, p0}, Landroid/support/v7/widget/g$f;-><init>(Landroid/support/v7/widget/g;)V

    iput-object v0, p0, Landroid/support/v7/widget/g;->D:Landroid/support/v7/widget/g$f;

    .line 89
    return-void
.end method

.method static synthetic a(Landroid/support/v7/widget/g;)Landroid/support/v7/view/menu/l;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/g;

    .line 53
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    return-object v0
.end method

.method private a(Landroid/view/MenuItem;)Landroid/view/View;
    .locals 6
    .param p1, "item"    # Landroid/view/MenuItem;

    .line 321
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    check-cast v0, Landroid/view/ViewGroup;

    .line 322
    .local v0, "parent":Landroid/view/ViewGroup;
    const/4 v1, 0x0

    if-nez v0, :cond_0

    return-object v1

    .line 324
    :cond_0
    invoke-virtual {v0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    .line 325
    .local v2, "count":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v2, :cond_2

    .line 326
    invoke-virtual {v0, v3}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 327
    .local v4, "child":Landroid/view/View;
    instance-of v5, v4, Landroid/support/v7/view/menu/w$a;

    if-eqz v5, :cond_1

    move-object v5, v4

    check-cast v5, Landroid/support/v7/view/menu/w$a;

    .line 328
    invoke-interface {v5}, Landroid/support/v7/view/menu/w$a;->getItemData()Landroid/support/v7/view/menu/p;

    move-result-object v5

    if-ne v5, p1, :cond_1

    .line 329
    return-object v4

    .line 325
    .end local v4    # "child":Landroid/view/View;
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 332
    .end local v3    # "i":I
    :cond_2
    return-object v1
.end method

.method static synthetic b(Landroid/support/v7/widget/g;)Landroid/support/v7/view/menu/l;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/g;

    .line 53
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    return-object v0
.end method

.method static synthetic c(Landroid/support/v7/widget/g;)Landroid/support/v7/view/menu/w;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/g;

    .line 53
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    return-object v0
.end method

.method static synthetic d(Landroid/support/v7/widget/g;)Landroid/support/v7/view/menu/l;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/g;

    .line 53
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    return-object v0
.end method

.method static synthetic e(Landroid/support/v7/widget/g;)Landroid/support/v7/view/menu/l;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/g;

    .line 53
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    return-object v0
.end method

.method static synthetic f(Landroid/support/v7/widget/g;)Landroid/support/v7/view/menu/w;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/g;

    .line 53
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    return-object v0
.end method


# virtual methods
.method public a(Landroid/support/v7/view/menu/p;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "item"    # Landroid/support/v7/view/menu/p;
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .line 195
    invoke-virtual {p1}, Landroid/support/v7/view/menu/p;->getActionView()Landroid/view/View;

    move-result-object v0

    .line 196
    .local v0, "actionView":Landroid/view/View;
    if-eqz v0, :cond_0

    invoke-virtual {p1}, Landroid/support/v7/view/menu/p;->f()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 197
    :cond_0
    invoke-super {p0, p1, p2, p3}, Landroid/support/v7/view/menu/b;->a(Landroid/support/v7/view/menu/p;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 199
    :cond_1
    invoke-virtual {p1}, Landroid/support/v7/view/menu/p;->isActionViewExpanded()Z

    move-result v1

    if-eqz v1, :cond_2

    const/16 v1, 0x8

    goto :goto_0

    :cond_2
    const/4 v1, 0x0

    :goto_0
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 201
    move-object v1, p3

    check-cast v1, Landroid/support/v7/widget/ActionMenuView;

    .line 202
    .local v1, "menuParent":Landroid/support/v7/widget/ActionMenuView;
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .line 203
    .local v2, "lp":Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual {v1, v2}, Landroid/support/v7/widget/ActionMenuView;->checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 204
    invoke-virtual {v1, v2}, Landroid/support/v7/widget/ActionMenuView;->generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/support/v7/widget/ActionMenuView$c;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 206
    :cond_3
    return-object v0
.end method

.method public a(Landroid/content/Context;Landroid/support/v7/view/menu/l;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "menu"    # Landroid/support/v7/view/menu/l;

    .line 93
    invoke-super {p0, p1, p2}, Landroid/support/v7/view/menu/b;->a(Landroid/content/Context;Landroid/support/v7/view/menu/l;)V

    .line 95
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 97
    .local v0, "res":Landroid/content/res/Resources;
    invoke-static {p1}, La/b/d/d/a;->a(Landroid/content/Context;)La/b/d/d/a;

    move-result-object v1

    .line 98
    .local v1, "abp":La/b/d/d/a;
    iget-boolean v2, p0, Landroid/support/v7/widget/g;->o:Z

    if-nez v2, :cond_0

    .line 99
    invoke-virtual {v1}, La/b/d/d/a;->g()Z

    move-result v2

    iput-boolean v2, p0, Landroid/support/v7/widget/g;->n:Z

    .line 102
    :cond_0
    iget-boolean v2, p0, Landroid/support/v7/widget/g;->u:Z

    if-nez v2, :cond_1

    .line 103
    invoke-virtual {v1}, La/b/d/d/a;->b()I

    move-result v2

    iput v2, p0, Landroid/support/v7/widget/g;->p:I

    .line 107
    :cond_1
    iget-boolean v2, p0, Landroid/support/v7/widget/g;->s:Z

    if-nez v2, :cond_2

    .line 108
    invoke-virtual {v1}, La/b/d/d/a;->c()I

    move-result v2

    iput v2, p0, Landroid/support/v7/widget/g;->r:I

    .line 111
    :cond_2
    iget v2, p0, Landroid/support/v7/widget/g;->p:I

    .line 112
    .local v2, "width":I
    iget-boolean v3, p0, Landroid/support/v7/widget/g;->n:Z

    const/4 v4, 0x0

    if-eqz v3, :cond_5

    .line 113
    iget-object v3, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    if-nez v3, :cond_4

    .line 114
    new-instance v3, Landroid/support/v7/widget/g$d;

    iget-object v5, p0, Landroid/support/v7/view/menu/b;->a:Landroid/content/Context;

    invoke-direct {v3, p0, v5}, Landroid/support/v7/widget/g$d;-><init>(Landroid/support/v7/widget/g;Landroid/content/Context;)V

    iput-object v3, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    .line 115
    iget-boolean v3, p0, Landroid/support/v7/widget/g;->m:Z

    const/4 v5, 0x0

    if-eqz v3, :cond_3

    .line 116
    iget-object v3, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    iget-object v6, p0, Landroid/support/v7/widget/g;->l:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3, v6}, Landroid/support/v7/widget/t;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 117
    iput-object v4, p0, Landroid/support/v7/widget/g;->l:Landroid/graphics/drawable/Drawable;

    .line 118
    iput-boolean v5, p0, Landroid/support/v7/widget/g;->m:Z

    .line 120
    :cond_3
    invoke-static {v5, v5}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    .line 121
    .local v3, "spec":I
    iget-object v5, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    invoke-virtual {v5, v3, v3}, Landroid/widget/ImageView;->measure(II)V

    .line 123
    .end local v3    # "spec":I
    :cond_4
    iget-object v3, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    invoke-virtual {v3}, Landroid/widget/ImageView;->getMeasuredWidth()I

    move-result v3

    sub-int/2addr v2, v3

    goto :goto_0

    .line 125
    :cond_5
    iput-object v4, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    .line 128
    :goto_0
    iput v2, p0, Landroid/support/v7/widget/g;->q:I

    .line 130
    const/high16 v3, 0x42600000    # 56.0f

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    iget v5, v5, Landroid/util/DisplayMetrics;->density:F

    mul-float v5, v5, v3

    float-to-int v3, v5

    iput v3, p0, Landroid/support/v7/widget/g;->w:I

    .line 133
    iput-object v4, p0, Landroid/support/v7/widget/g;->y:Landroid/view/View;

    .line 134
    return-void
.end method

.method public a(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .line 137
    iget-boolean v0, p0, Landroid/support/v7/widget/g;->s:Z

    if-nez v0, :cond_0

    .line 138
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->b:Landroid/content/Context;

    invoke-static {v0}, La/b/d/d/a;->a(Landroid/content/Context;)La/b/d/d/a;

    move-result-object v0

    invoke-virtual {v0}, La/b/d/d/a;->c()I

    move-result v0

    iput v0, p0, Landroid/support/v7/widget/g;->r:I

    .line 140
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    if-eqz v0, :cond_1

    .line 141
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/l;->b(Z)V

    .line 143
    :cond_1
    return-void
.end method

.method public a(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .line 166
    iget-object v0, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    if-eqz v0, :cond_0

    .line 167
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/t;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 169
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/g;->m:Z

    .line 170
    iput-object p1, p0, Landroid/support/v7/widget/g;->l:Landroid/graphics/drawable/Drawable;

    .line 172
    :goto_0
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;Z)V
    .locals 0
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "allMenusAreClosing"    # Z

    .line 562
    invoke-virtual {p0}, Landroid/support/v7/widget/g;->c()Z

    .line 563
    invoke-super {p0, p1, p2}, Landroid/support/v7/view/menu/b;->a(Landroid/support/v7/view/menu/l;Z)V

    .line 564
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/p;Landroid/support/v7/view/menu/w$a;)V
    .locals 3
    .param p1, "item"    # Landroid/support/v7/view/menu/p;
    .param p2, "itemView"    # Landroid/support/v7/view/menu/w$a;

    .line 211
    const/4 v0, 0x0

    invoke-interface {p2, p1, v0}, Landroid/support/v7/view/menu/w$a;->a(Landroid/support/v7/view/menu/p;I)V

    .line 213
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    check-cast v0, Landroid/support/v7/widget/ActionMenuView;

    .line 214
    .local v0, "menuView":Landroid/support/v7/widget/ActionMenuView;
    move-object v1, p2

    check-cast v1, Landroid/support/v7/view/menu/ActionMenuItemView;

    .line 215
    .local v1, "actionItemView":Landroid/support/v7/view/menu/ActionMenuItemView;
    invoke-virtual {v1, v0}, Landroid/support/v7/view/menu/ActionMenuItemView;->setItemInvoker(Landroid/support/v7/view/menu/l$b;)V

    .line 217
    iget-object v2, p0, Landroid/support/v7/widget/g;->C:Landroid/support/v7/widget/g$b;

    if-nez v2, :cond_0

    .line 218
    new-instance v2, Landroid/support/v7/widget/g$b;

    invoke-direct {v2, p0}, Landroid/support/v7/widget/g$b;-><init>(Landroid/support/v7/widget/g;)V

    iput-object v2, p0, Landroid/support/v7/widget/g;->C:Landroid/support/v7/widget/g$b;

    .line 220
    :cond_0
    iget-object v2, p0, Landroid/support/v7/widget/g;->C:Landroid/support/v7/widget/g$b;

    invoke-virtual {v1, v2}, Landroid/support/v7/view/menu/ActionMenuItemView;->setPopupCallback(Landroid/support/v7/view/menu/ActionMenuItemView$b;)V

    .line 221
    return-void
.end method

.method public a(Landroid/support/v7/widget/ActionMenuView;)V
    .locals 1
    .param p1, "menuView"    # Landroid/support/v7/widget/ActionMenuView;

    .line 600
    iput-object p1, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    .line 601
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    invoke-virtual {p1, v0}, Landroid/support/v7/widget/ActionMenuView;->a(Landroid/support/v7/view/menu/l;)V

    .line 602
    return-void
.end method

.method public a(Z)V
    .locals 6
    .param p1, "cleared"    # Z

    .line 230
    invoke-super {p0, p1}, Landroid/support/v7/view/menu/b;->a(Z)V

    .line 232
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->requestLayout()V

    .line 234
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    if-eqz v0, :cond_1

    .line 235
    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->c()Ljava/util/ArrayList;

    move-result-object v0

    .line 236
    .local v0, "actionItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 237
    .local v1, "count":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_1

    .line 238
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v7/view/menu/p;

    invoke-virtual {v3}, Landroid/support/v7/view/menu/p;->a()La/b/c/g/e;

    move-result-object v3

    .line 239
    .local v3, "provider":La/b/c/g/e;
    if-eqz v3, :cond_0

    .line 240
    invoke-virtual {v3, p0}, La/b/c/g/e;->a(La/b/c/g/e$a;)V

    .line 237
    .end local v3    # "provider":La/b/c/g/e;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 245
    .end local v0    # "actionItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .end local v1    # "count":I
    .end local v2    # "i":I
    :cond_1
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    if-eqz v0, :cond_2

    .line 246
    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->j()Ljava/util/ArrayList;

    move-result-object v0

    goto :goto_1

    :cond_2
    const/4 v0, 0x0

    .line 248
    .local v0, "nonActionItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    :goto_1
    const/4 v1, 0x0

    .line 249
    .local v1, "hasOverflow":Z
    iget-boolean v2, p0, Landroid/support/v7/widget/g;->n:Z

    if-eqz v2, :cond_5

    if-eqz v0, :cond_5

    .line 250
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 251
    .local v2, "count":I
    const/4 v3, 0x0

    const/4 v4, 0x1

    if-ne v2, v4, :cond_3

    .line 252
    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v7/view/menu/p;

    invoke-virtual {v3}, Landroid/support/v7/view/menu/p;->isActionViewExpanded()Z

    move-result v3

    xor-int/2addr v3, v4

    move v1, v3

    goto :goto_2

    .line 254
    :cond_3
    if-lez v2, :cond_4

    const/4 v3, 0x1

    :cond_4
    move v1, v3

    .line 258
    .end local v2    # "count":I
    :cond_5
    :goto_2
    if-eqz v1, :cond_8

    .line 259
    iget-object v2, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    if-nez v2, :cond_6

    .line 260
    new-instance v2, Landroid/support/v7/widget/g$d;

    iget-object v3, p0, Landroid/support/v7/view/menu/b;->a:Landroid/content/Context;

    invoke-direct {v2, p0, v3}, Landroid/support/v7/widget/g$d;-><init>(Landroid/support/v7/widget/g;Landroid/content/Context;)V

    iput-object v2, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    .line 262
    :cond_6
    iget-object v2, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    invoke-virtual {v2}, Landroid/widget/ImageView;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 263
    .local v2, "parent":Landroid/view/ViewGroup;
    iget-object v3, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    if-eq v2, v3, :cond_9

    .line 264
    if-eqz v2, :cond_7

    .line 265
    iget-object v3, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 267
    :cond_7
    iget-object v3, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    check-cast v3, Landroid/support/v7/widget/ActionMenuView;

    .line 268
    .local v3, "menuView":Landroid/support/v7/widget/ActionMenuView;
    iget-object v4, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    invoke-virtual {v3}, Landroid/support/v7/widget/ActionMenuView;->b()Landroid/support/v7/widget/ActionMenuView$c;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_3

    .line 270
    .end local v2    # "parent":Landroid/view/ViewGroup;
    .end local v3    # "menuView":Landroid/support/v7/widget/ActionMenuView;
    :cond_8
    iget-object v2, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    if-eqz v2, :cond_9

    invoke-virtual {v2}, Landroid/widget/ImageView;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    iget-object v3, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    if-ne v2, v3, :cond_9

    .line 271
    check-cast v3, Landroid/view/ViewGroup;

    iget-object v2, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    invoke-virtual {v3, v2}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_4

    .line 270
    :cond_9
    :goto_3
    nop

    .line 274
    :goto_4
    iget-object v2, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    check-cast v2, Landroid/support/v7/widget/ActionMenuView;

    iget-boolean v3, p0, Landroid/support/v7/widget/g;->n:Z

    invoke-virtual {v2, v3}, Landroid/support/v7/widget/ActionMenuView;->setOverflowReserved(Z)V

    .line 275
    return-void
.end method

.method public a()Z
    .locals 24

    .line 421
    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    if-eqz v1, :cond_0

    .line 422
    invoke-virtual {v1}, Landroid/support/v7/view/menu/l;->n()Ljava/util/ArrayList;

    move-result-object v1

    .line 423
    .local v1, "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    .local v2, "itemsSize":I
    goto :goto_0

    .line 425
    .end local v1    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .end local v2    # "itemsSize":I
    :cond_0
    const/4 v1, 0x0

    .line 426
    .restart local v1    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    const/4 v2, 0x0

    .line 429
    .restart local v2    # "itemsSize":I
    :goto_0
    iget v3, v0, Landroid/support/v7/widget/g;->r:I

    .line 430
    .local v3, "maxActions":I
    iget v4, v0, Landroid/support/v7/widget/g;->q:I

    .line 431
    .local v4, "widthLimit":I
    const/4 v5, 0x0

    invoke-static {v5, v5}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v6

    .line 432
    .local v6, "querySpec":I
    iget-object v7, v0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    check-cast v7, Landroid/view/ViewGroup;

    .line 434
    .local v7, "parent":Landroid/view/ViewGroup;
    const/4 v8, 0x0

    .line 435
    .local v8, "requiredItems":I
    const/4 v9, 0x0

    .line 436
    .local v9, "requestedItems":I
    const/4 v10, 0x0

    .line 437
    .local v10, "firstActionWidth":I
    const/4 v11, 0x0

    .line 438
    .local v11, "hasOverflow":Z
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_1
    if-ge v12, v2, :cond_4

    .line 439
    invoke-virtual {v1, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroid/support/v7/view/menu/p;

    .line 440
    .local v13, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v13}, Landroid/support/v7/view/menu/p;->k()Z

    move-result v14

    if-eqz v14, :cond_1

    .line 441
    add-int/lit8 v8, v8, 0x1

    goto :goto_2

    .line 442
    :cond_1
    invoke-virtual {v13}, Landroid/support/v7/view/menu/p;->j()Z

    move-result v14

    if-eqz v14, :cond_2

    .line 443
    add-int/lit8 v9, v9, 0x1

    goto :goto_2

    .line 445
    :cond_2
    const/4 v11, 0x1

    .line 447
    :goto_2
    iget-boolean v14, v0, Landroid/support/v7/widget/g;->v:Z

    if-eqz v14, :cond_3

    invoke-virtual {v13}, Landroid/support/v7/view/menu/p;->isActionViewExpanded()Z

    move-result v14

    if-eqz v14, :cond_3

    .line 450
    const/4 v3, 0x0

    .line 438
    .end local v13    # "item":Landroid/support/v7/view/menu/p;
    :cond_3
    add-int/lit8 v12, v12, 0x1

    goto :goto_1

    .line 455
    .end local v12    # "i":I
    :cond_4
    iget-boolean v12, v0, Landroid/support/v7/widget/g;->n:Z

    if-eqz v12, :cond_6

    if-nez v11, :cond_5

    add-int v12, v8, v9

    if-le v12, v3, :cond_6

    .line 457
    :cond_5
    add-int/lit8 v3, v3, -0x1

    .line 459
    :cond_6
    sub-int/2addr v3, v8

    .line 461
    iget-object v12, v0, Landroid/support/v7/widget/g;->x:Landroid/util/SparseBooleanArray;

    .line 462
    .local v12, "seenGroups":Landroid/util/SparseBooleanArray;
    invoke-virtual {v12}, Landroid/util/SparseBooleanArray;->clear()V

    .line 464
    const/4 v13, 0x0

    .line 465
    .local v13, "cellSize":I
    const/4 v14, 0x0

    .line 466
    .local v14, "cellsRemaining":I
    iget-boolean v15, v0, Landroid/support/v7/widget/g;->t:Z

    if-eqz v15, :cond_7

    .line 467
    iget v15, v0, Landroid/support/v7/widget/g;->w:I

    div-int v14, v4, v15

    .line 468
    rem-int v16, v4, v15

    .line 469
    .local v16, "cellSizeRemaining":I
    div-int v17, v16, v14

    add-int v13, v15, v17

    .line 473
    .end local v16    # "cellSizeRemaining":I
    :cond_7
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_3
    if-ge v15, v2, :cond_21

    .line 474
    invoke-virtual {v1, v15}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v5, v17

    check-cast v5, Landroid/support/v7/view/menu/p;

    .line 476
    .local v5, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {v5}, Landroid/support/v7/view/menu/p;->k()Z

    move-result v17

    if-eqz v17, :cond_c

    .line 477
    move/from16 v17, v2

    .end local v2    # "itemsSize":I
    .local v17, "itemsSize":I
    iget-object v2, v0, Landroid/support/v7/widget/g;->y:Landroid/view/View;

    invoke-virtual {v0, v5, v2, v7}, Landroid/support/v7/widget/g;->a(Landroid/support/v7/view/menu/p;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 478
    .local v2, "v":Landroid/view/View;
    move/from16 v19, v8

    .end local v8    # "requiredItems":I
    .local v19, "requiredItems":I
    iget-object v8, v0, Landroid/support/v7/widget/g;->y:Landroid/view/View;

    if-nez v8, :cond_8

    .line 479
    iput-object v2, v0, Landroid/support/v7/widget/g;->y:Landroid/view/View;

    .line 481
    :cond_8
    iget-boolean v8, v0, Landroid/support/v7/widget/g;->t:Z

    if-eqz v8, :cond_9

    .line 482
    const/4 v8, 0x0

    invoke-static {v2, v13, v14, v6, v8}, Landroid/support/v7/widget/ActionMenuView;->a(Landroid/view/View;IIII)I

    move-result v20

    sub-int v14, v14, v20

    goto :goto_4

    .line 485
    :cond_9
    invoke-virtual {v2, v6, v6}, Landroid/view/View;->measure(II)V

    .line 487
    :goto_4
    invoke-virtual {v2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v8

    .line 488
    .local v8, "measuredWidth":I
    sub-int/2addr v4, v8

    .line 489
    if-nez v10, :cond_a

    .line 490
    move v10, v8

    .line 492
    :cond_a
    move-object/from16 v20, v2

    .end local v2    # "v":Landroid/view/View;
    .local v20, "v":Landroid/view/View;
    invoke-virtual {v5}, Landroid/support/v7/view/menu/p;->getGroupId()I

    move-result v2

    .line 493
    .local v2, "groupId":I
    if-eqz v2, :cond_b

    .line 494
    move/from16 v21, v4

    const/4 v4, 0x1

    .end local v4    # "widthLimit":I
    .local v21, "widthLimit":I
    invoke-virtual {v12, v2, v4}, Landroid/util/SparseBooleanArray;->put(IZ)V

    goto :goto_5

    .line 493
    .end local v21    # "widthLimit":I
    .restart local v4    # "widthLimit":I
    :cond_b
    move/from16 v21, v4

    const/4 v4, 0x1

    .line 496
    .end local v4    # "widthLimit":I
    .restart local v21    # "widthLimit":I
    :goto_5
    invoke-virtual {v5, v4}, Landroid/support/v7/view/menu/p;->d(Z)V

    .line 497
    .end local v2    # "groupId":I
    .end local v8    # "measuredWidth":I
    .end local v20    # "v":Landroid/view/View;
    move-object/from16 v22, v7

    move/from16 v4, v21

    const/4 v0, 0x0

    move-object/from16 v21, v1

    goto/16 :goto_f

    .end local v17    # "itemsSize":I
    .end local v19    # "requiredItems":I
    .end local v21    # "widthLimit":I
    .local v2, "itemsSize":I
    .restart local v4    # "widthLimit":I
    .local v8, "requiredItems":I
    :cond_c
    move/from16 v17, v2

    move/from16 v19, v8

    .end local v2    # "itemsSize":I
    .end local v8    # "requiredItems":I
    .restart local v17    # "itemsSize":I
    .restart local v19    # "requiredItems":I
    invoke-virtual {v5}, Landroid/support/v7/view/menu/p;->j()Z

    move-result v2

    if-eqz v2, :cond_20

    .line 500
    invoke-virtual {v5}, Landroid/support/v7/view/menu/p;->getGroupId()I

    move-result v2

    .line 501
    .local v2, "groupId":I
    invoke-virtual {v12, v2}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v8

    .line 502
    .local v8, "inGroup":Z
    if-gtz v3, :cond_e

    if-eqz v8, :cond_d

    goto :goto_6

    :cond_d
    move/from16 v20, v3

    goto :goto_7

    :cond_e
    :goto_6
    if-lez v4, :cond_10

    move/from16 v20, v3

    .end local v3    # "maxActions":I
    .local v20, "maxActions":I
    iget-boolean v3, v0, Landroid/support/v7/widget/g;->t:Z

    if-eqz v3, :cond_f

    if-lez v14, :cond_11

    :cond_f
    const/4 v3, 0x1

    goto :goto_8

    .end local v20    # "maxActions":I
    .restart local v3    # "maxActions":I
    :cond_10
    move/from16 v20, v3

    .end local v3    # "maxActions":I
    .restart local v20    # "maxActions":I
    :cond_11
    :goto_7
    const/4 v3, 0x0

    .line 505
    .local v3, "isAction":Z
    :goto_8
    if-eqz v3, :cond_19

    .line 506
    move/from16 v21, v3

    .end local v3    # "isAction":Z
    .local v21, "isAction":Z
    iget-object v3, v0, Landroid/support/v7/widget/g;->y:Landroid/view/View;

    invoke-virtual {v0, v5, v3, v7}, Landroid/support/v7/widget/g;->a(Landroid/support/v7/view/menu/p;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 507
    .local v3, "v":Landroid/view/View;
    move-object/from16 v22, v7

    .end local v7    # "parent":Landroid/view/ViewGroup;
    .local v22, "parent":Landroid/view/ViewGroup;
    iget-object v7, v0, Landroid/support/v7/widget/g;->y:Landroid/view/View;

    if-nez v7, :cond_12

    .line 508
    iput-object v3, v0, Landroid/support/v7/widget/g;->y:Landroid/view/View;

    .line 510
    :cond_12
    iget-boolean v7, v0, Landroid/support/v7/widget/g;->t:Z

    if-eqz v7, :cond_14

    .line 511
    const/4 v7, 0x0

    invoke-static {v3, v13, v14, v6, v7}, Landroid/support/v7/widget/ActionMenuView;->a(Landroid/view/View;IIII)I

    move-result v23

    .line 513
    .local v23, "cells":I
    sub-int v14, v14, v23

    .line 514
    if-nez v23, :cond_13

    .line 515
    const/4 v7, 0x0

    move/from16 v21, v7

    .line 517
    .end local v23    # "cells":I
    :cond_13
    goto :goto_9

    .line 518
    :cond_14
    invoke-virtual {v3, v6, v6}, Landroid/view/View;->measure(II)V

    .line 520
    :goto_9
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    .line 521
    .local v7, "measuredWidth":I
    sub-int/2addr v4, v7

    .line 522
    if-nez v10, :cond_15

    .line 523
    move v10, v7

    .line 526
    :cond_15
    move-object/from16 v23, v3

    .end local v3    # "v":Landroid/view/View;
    .local v23, "v":Landroid/view/View;
    iget-boolean v3, v0, Landroid/support/v7/widget/g;->t:Z

    if-eqz v3, :cond_17

    .line 527
    if-ltz v4, :cond_16

    const/4 v3, 0x1

    goto :goto_a

    :cond_16
    const/4 v3, 0x0

    :goto_a
    and-int v3, v21, v3

    .end local v21    # "isAction":Z
    .local v3, "isAction":Z
    goto :goto_c

    .line 530
    .end local v3    # "isAction":Z
    .restart local v21    # "isAction":Z
    :cond_17
    add-int v3, v4, v10

    if-lez v3, :cond_18

    const/4 v3, 0x1

    goto :goto_b

    :cond_18
    const/4 v3, 0x0

    :goto_b
    and-int v3, v21, v3

    .end local v21    # "isAction":Z
    .restart local v3    # "isAction":Z
    goto :goto_c

    .line 505
    .end local v22    # "parent":Landroid/view/ViewGroup;
    .end local v23    # "v":Landroid/view/View;
    .local v7, "parent":Landroid/view/ViewGroup;
    :cond_19
    move/from16 v21, v3

    move-object/from16 v22, v7

    .line 534
    .end local v7    # "parent":Landroid/view/ViewGroup;
    .restart local v22    # "parent":Landroid/view/ViewGroup;
    :goto_c
    if-eqz v3, :cond_1a

    if-eqz v2, :cond_1a

    .line 535
    const/4 v7, 0x1

    invoke-virtual {v12, v2, v7}, Landroid/util/SparseBooleanArray;->put(IZ)V

    move-object/from16 v21, v1

    goto :goto_e

    .line 536
    :cond_1a
    if-eqz v8, :cond_1e

    .line 538
    const/4 v7, 0x0

    invoke-virtual {v12, v2, v7}, Landroid/util/SparseBooleanArray;->put(IZ)V

    .line 539
    const/4 v7, 0x0

    .local v7, "j":I
    :goto_d
    if-ge v7, v15, :cond_1d

    .line 540
    invoke-virtual {v1, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v18

    move-object/from16 v0, v18

    check-cast v0, Landroid/support/v7/view/menu/p;

    .line 541
    .local v0, "areYouMyGroupie":Landroid/support/v7/view/menu/p;
    move-object/from16 v21, v1

    .end local v1    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .local v21, "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    invoke-virtual {v0}, Landroid/support/v7/view/menu/p;->getGroupId()I

    move-result v1

    if-ne v1, v2, :cond_1c

    .line 543
    invoke-virtual {v0}, Landroid/support/v7/view/menu/p;->h()Z

    move-result v1

    if-eqz v1, :cond_1b

    add-int/lit8 v20, v20, 0x1

    .line 544
    :cond_1b
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/p;->d(Z)V

    .line 539
    .end local v0    # "areYouMyGroupie":Landroid/support/v7/view/menu/p;
    :cond_1c
    add-int/lit8 v7, v7, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    goto :goto_d

    .end local v21    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .restart local v1    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    :cond_1d
    move-object/from16 v21, v1

    .end local v1    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .restart local v21    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    goto :goto_e

    .line 536
    .end local v7    # "j":I
    .end local v21    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .restart local v1    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    :cond_1e
    move-object/from16 v21, v1

    .line 549
    .end local v1    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .restart local v21    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    :goto_e
    if-eqz v3, :cond_1f

    add-int/lit8 v20, v20, -0x1

    .line 551
    :cond_1f
    invoke-virtual {v5, v3}, Landroid/support/v7/view/menu/p;->d(Z)V

    .line 552
    .end local v2    # "groupId":I
    .end local v3    # "isAction":Z
    .end local v8    # "inGroup":Z
    move/from16 v3, v20

    const/4 v0, 0x0

    goto :goto_f

    .line 554
    .end local v20    # "maxActions":I
    .end local v21    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .end local v22    # "parent":Landroid/view/ViewGroup;
    .restart local v1    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .local v3, "maxActions":I
    .local v7, "parent":Landroid/view/ViewGroup;
    :cond_20
    move-object/from16 v21, v1

    move/from16 v20, v3

    move-object/from16 v22, v7

    .end local v1    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .end local v3    # "maxActions":I
    .end local v7    # "parent":Landroid/view/ViewGroup;
    .restart local v20    # "maxActions":I
    .restart local v21    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .restart local v22    # "parent":Landroid/view/ViewGroup;
    const/4 v0, 0x0

    invoke-virtual {v5, v0}, Landroid/support/v7/view/menu/p;->d(Z)V

    .line 473
    .end local v5    # "item":Landroid/support/v7/view/menu/p;
    .end local v20    # "maxActions":I
    .restart local v3    # "maxActions":I
    :goto_f
    add-int/lit8 v15, v15, 0x1

    const/4 v5, 0x0

    move-object/from16 v0, p0

    move/from16 v2, v17

    move/from16 v8, v19

    move-object/from16 v1, v21

    move-object/from16 v7, v22

    goto/16 :goto_3

    .end local v17    # "itemsSize":I
    .end local v19    # "requiredItems":I
    .end local v21    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .end local v22    # "parent":Landroid/view/ViewGroup;
    .restart local v1    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .local v2, "itemsSize":I
    .restart local v7    # "parent":Landroid/view/ViewGroup;
    .local v8, "requiredItems":I
    :cond_21
    move-object/from16 v21, v1

    move/from16 v17, v2

    move/from16 v20, v3

    move-object/from16 v22, v7

    move/from16 v19, v8

    .line 557
    .end local v1    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .end local v2    # "itemsSize":I
    .end local v3    # "maxActions":I
    .end local v7    # "parent":Landroid/view/ViewGroup;
    .end local v8    # "requiredItems":I
    .end local v15    # "i":I
    .restart local v17    # "itemsSize":I
    .restart local v19    # "requiredItems":I
    .restart local v20    # "maxActions":I
    .restart local v21    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .restart local v22    # "parent":Landroid/view/ViewGroup;
    const/4 v0, 0x1

    return v0
.end method

.method public a(ILandroid/support/v7/view/menu/p;)Z
    .locals 1
    .param p1, "childIndex"    # I
    .param p2, "item"    # Landroid/support/v7/view/menu/p;

    .line 225
    invoke-virtual {p2}, Landroid/support/v7/view/menu/p;->h()Z

    move-result v0

    return v0
.end method

.method public a(Landroid/support/v7/view/menu/D;)Z
    .locals 7
    .param p1, "subMenu"    # Landroid/support/v7/view/menu/D;

    .line 285
    invoke-virtual {p1}, Landroid/support/v7/view/menu/l;->hasVisibleItems()Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    return v1

    .line 287
    :cond_0
    move-object v0, p1

    .line 288
    .local v0, "topSubMenu":Landroid/support/v7/view/menu/D;
    :goto_0
    invoke-virtual {v0}, Landroid/support/v7/view/menu/D;->t()Landroid/view/Menu;

    move-result-object v2

    iget-object v3, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    if-eq v2, v3, :cond_1

    .line 289
    invoke-virtual {v0}, Landroid/support/v7/view/menu/D;->t()Landroid/view/Menu;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Landroid/support/v7/view/menu/D;

    goto :goto_0

    .line 291
    :cond_1
    invoke-virtual {v0}, Landroid/support/v7/view/menu/D;->getItem()Landroid/view/MenuItem;

    move-result-object v2

    invoke-direct {p0, v2}, Landroid/support/v7/widget/g;->a(Landroid/view/MenuItem;)Landroid/view/View;

    move-result-object v2

    .line 292
    .local v2, "anchor":Landroid/view/View;
    if-nez v2, :cond_2

    .line 297
    return v1

    .line 300
    :cond_2
    invoke-virtual {p1}, Landroid/support/v7/view/menu/D;->getItem()Landroid/view/MenuItem;

    move-result-object v1

    invoke-interface {v1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    iput v1, p0, Landroid/support/v7/widget/g;->E:I

    .line 302
    const/4 v1, 0x0

    .line 303
    .local v1, "preserveIconSpacing":Z
    invoke-virtual {p1}, Landroid/support/v7/view/menu/l;->size()I

    move-result v3

    .line 304
    .local v3, "count":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    if-ge v4, v3, :cond_4

    .line 305
    invoke-virtual {p1, v4}, Landroid/support/v7/view/menu/l;->getItem(I)Landroid/view/MenuItem;

    move-result-object v5

    .line 306
    .local v5, "childItem":Landroid/view/MenuItem;
    invoke-interface {v5}, Landroid/view/MenuItem;->isVisible()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v5}, Landroid/view/MenuItem;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v6

    if-eqz v6, :cond_3

    .line 307
    const/4 v1, 0x1

    .line 308
    goto :goto_2

    .line 304
    .end local v5    # "childItem":Landroid/view/MenuItem;
    :cond_3
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 312
    .end local v4    # "i":I
    :cond_4
    :goto_2
    new-instance v4, Landroid/support/v7/widget/g$a;

    iget-object v5, p0, Landroid/support/v7/view/menu/b;->b:Landroid/content/Context;

    invoke-direct {v4, p0, v5, p1, v2}, Landroid/support/v7/widget/g$a;-><init>(Landroid/support/v7/widget/g;Landroid/content/Context;Landroid/support/v7/view/menu/D;Landroid/view/View;)V

    iput-object v4, p0, Landroid/support/v7/widget/g;->A:Landroid/support/v7/widget/g$a;

    .line 313
    iget-object v4, p0, Landroid/support/v7/widget/g;->A:Landroid/support/v7/widget/g$a;

    invoke-virtual {v4, v1}, Landroid/support/v7/view/menu/u;->a(Z)V

    .line 314
    iget-object v4, p0, Landroid/support/v7/widget/g;->A:Landroid/support/v7/widget/g$a;

    invoke-virtual {v4}, Landroid/support/v7/view/menu/u;->e()V

    .line 316
    invoke-super {p0, p1}, Landroid/support/v7/view/menu/b;->a(Landroid/support/v7/view/menu/D;)Z

    .line 317
    const/4 v4, 0x1

    return v4
.end method

.method public a(Landroid/view/ViewGroup;I)Z
    .locals 2
    .param p1, "parent"    # Landroid/view/ViewGroup;
    .param p2, "childIndex"    # I

    .line 279
    invoke-virtual {p1, p2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x0

    return v0

    .line 280
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/support/v7/view/menu/b;->a(Landroid/view/ViewGroup;I)Z

    move-result v0

    return v0
.end method

.method public b(Landroid/view/ViewGroup;)Landroid/support/v7/view/menu/w;
    .locals 3
    .param p1, "root"    # Landroid/view/ViewGroup;

    .line 185
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    .line 186
    .local v0, "oldMenuView":Landroid/support/v7/view/menu/w;
    invoke-super {p0, p1}, Landroid/support/v7/view/menu/b;->b(Landroid/view/ViewGroup;)Landroid/support/v7/view/menu/w;

    move-result-object v1

    .line 187
    .local v1, "result":Landroid/support/v7/view/menu/w;
    if-eq v0, v1, :cond_0

    .line 188
    move-object v2, v1

    check-cast v2, Landroid/support/v7/widget/ActionMenuView;

    invoke-virtual {v2, p0}, Landroid/support/v7/widget/ActionMenuView;->setPresenter(Landroid/support/v7/widget/g;)V

    .line 190
    :cond_0
    return-object v1
.end method

.method public b(Z)V
    .locals 0
    .param p1, "isExclusive"    # Z

    .line 162
    iput-boolean p1, p0, Landroid/support/v7/widget/g;->v:Z

    .line 163
    return-void
.end method

.method public c(Z)V
    .locals 1
    .param p1, "reserveOverflow"    # Z

    .line 152
    iput-boolean p1, p0, Landroid/support/v7/widget/g;->n:Z

    .line 153
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/g;->o:Z

    .line 154
    return-void
.end method

.method public c()Z
    .locals 2

    .line 381
    invoke-virtual {p0}, Landroid/support/v7/widget/g;->e()Z

    move-result v0

    .line 382
    .local v0, "result":Z
    invoke-virtual {p0}, Landroid/support/v7/widget/g;->f()Z

    move-result v1

    or-int/2addr v0, v1

    .line 383
    return v0
.end method

.method public d()Landroid/graphics/drawable/Drawable;
    .locals 1

    .line 175
    iget-object v0, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    if-eqz v0, :cond_0

    .line 176
    invoke-virtual {v0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0

    .line 177
    :cond_0
    iget-boolean v0, p0, Landroid/support/v7/widget/g;->m:Z

    if-eqz v0, :cond_1

    .line 178
    iget-object v0, p0, Landroid/support/v7/widget/g;->l:Landroid/graphics/drawable/Drawable;

    return-object v0

    .line 180
    :cond_1
    const/4 v0, 0x0

    return-object v0
.end method

.method public e()Z
    .locals 3

    .line 362
    iget-object v0, p0, Landroid/support/v7/widget/g;->B:Landroid/support/v7/widget/g$c;

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    iget-object v2, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    if-eqz v2, :cond_0

    .line 363
    check-cast v2, Landroid/view/View;

    invoke-virtual {v2, v0}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 364
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/widget/g;->B:Landroid/support/v7/widget/g$c;

    .line 365
    return v1

    .line 368
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/g;->z:Landroid/support/v7/widget/g$e;

    .line 369
    .local v0, "popup":Landroid/support/v7/view/menu/u;
    if-eqz v0, :cond_1

    .line 370
    invoke-virtual {v0}, Landroid/support/v7/view/menu/u;->a()V

    .line 371
    return v1

    .line 373
    :cond_1
    const/4 v1, 0x0

    return v1
.end method

.method public f()Z
    .locals 1

    .line 392
    iget-object v0, p0, Landroid/support/v7/widget/g;->A:Landroid/support/v7/widget/g$a;

    if-eqz v0, :cond_0

    .line 393
    invoke-virtual {v0}, Landroid/support/v7/view/menu/u;->a()V

    .line 394
    const/4 v0, 0x1

    return v0

    .line 396
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public g()Z
    .locals 1

    .line 407
    iget-object v0, p0, Landroid/support/v7/widget/g;->B:Landroid/support/v7/widget/g$c;

    if-nez v0, :cond_1

    invoke-virtual {p0}, Landroid/support/v7/widget/g;->h()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method public h()Z
    .locals 1

    .line 403
    iget-object v0, p0, Landroid/support/v7/widget/g;->z:Landroid/support/v7/widget/g$e;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/view/menu/u;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public i()Z
    .locals 7

    .line 340
    iget-boolean v0, p0, Landroid/support/v7/widget/g;->n:Z

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Landroid/support/v7/widget/g;->h()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    if-eqz v0, :cond_0

    iget-object v1, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    if-eqz v1, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/g;->B:Landroid/support/v7/widget/g$c;

    if-nez v1, :cond_0

    .line 341
    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->j()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 342
    new-instance v0, Landroid/support/v7/widget/g$e;

    iget-object v3, p0, Landroid/support/v7/view/menu/b;->b:Landroid/content/Context;

    iget-object v4, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    iget-object v5, p0, Landroid/support/v7/widget/g;->k:Landroid/support/v7/widget/g$d;

    const/4 v6, 0x1

    move-object v1, v0

    move-object v2, p0

    invoke-direct/range {v1 .. v6}, Landroid/support/v7/widget/g$e;-><init>(Landroid/support/v7/widget/g;Landroid/content/Context;Landroid/support/v7/view/menu/l;Landroid/view/View;Z)V

    .line 343
    .local v0, "popup":Landroid/support/v7/widget/g$e;
    new-instance v1, Landroid/support/v7/widget/g$c;

    invoke-direct {v1, p0, v0}, Landroid/support/v7/widget/g$c;-><init>(Landroid/support/v7/widget/g;Landroid/support/v7/widget/g$e;)V

    iput-object v1, p0, Landroid/support/v7/widget/g;->B:Landroid/support/v7/widget/g$c;

    .line 345
    iget-object v1, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    check-cast v1, Landroid/view/View;

    iget-object v2, p0, Landroid/support/v7/widget/g;->B:Landroid/support/v7/widget/g$c;

    invoke-virtual {v1, v2}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    .line 349
    const/4 v1, 0x0

    invoke-super {p0, v1}, Landroid/support/v7/view/menu/b;->a(Landroid/support/v7/view/menu/D;)Z

    .line 351
    const/4 v1, 0x1

    return v1

    .line 353
    .end local v0    # "popup":Landroid/support/v7/widget/g$e;
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

package soc.common.server.rating;

import soc.common.game.variants.Variant;

/*
 * Rating for contained variant
 */
public interface VariantRating extends Rating
{
    public Variant getVariant();
}

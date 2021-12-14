ALTER TABLE sights RENAME COLUMN xCoordinate TO x_coordinate;
ALTER TABLE sights RENAME COLUMN yCoordinate TO y_coordinate;
ALTER TABLE sights RENAME COLUMN siteLink TO site_link;
ALTER TABLE sights RENAME COLUMN openTime TO open_time;
ALTER TABLE sights RENAME COLUMN closeTime TO close_time;
ALTER TABLE bars RENAME COLUMN forAdults TO for_adults;
ALTER TABLE cafes RENAME COLUMN foodType TO food_type;
ALTER TABLE museums RENAME COLUMN discountForChildren TO discount_for_children;
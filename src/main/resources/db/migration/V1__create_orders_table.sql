CREATE SEQUENCE s_order
    INCREMENT BY 1
    MINVALUE 1
    START 1;

CREATE TABLE IF NOT EXISTS public.orders
(
    id                  BIGINT                   NOT NULL PRIMARY KEY DEFAULT nextval('s_order'),
    customer_id         BIGINT                   NOT NULL,
    restaurant_id       BIGINT                   NOT NULL,
    restaurant_owner_id BIGINT                   NOT NULL,
    restaurant_name     VARCHAR(255)             NOT NULL,
    status              VARCHAR(100)             NOT NULL,
    subtotal            NUMERIC(12, 2)           NOT NULL,
    delivery_fee        NUMERIC(12, 2)           NOT NULL,
    total_amount        NUMERIC(12, 2)           NOT NULL,

    delivery_city       VARCHAR(100)             NOT NULL,
    delivery_street     VARCHAR(255)             NOT NULL,
    delivery_building   VARCHAR(20)              NOT NULL,
    delivery_apartment  VARCHAR(20),
    delivery_entrance   VARCHAR(10),
    delivery_floor      VARCHAR(10),
    delivery_lat        NUMERIC(9, 6),
    delivery_lon        NUMERIC(9, 6),
    delivery_comment    VARCHAR(500),

    customer_comment    VARCHAR(500),
    idempotency_key     UUID                     NOT NULL,
    version             BIGINT                   NOT NULL,
    cancellation_reason VARCHAR(500),
    created_at          TIMESTAMP WITH TIME ZONE NOT NULL             DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP WITH TIME ZONE,

    CONSTRAINT uk_orders_customer_idempotency UNIQUE (customer_id, idempotency_key),
    CONSTRAINT chk_orders_lat CHECK (delivery_lat BETWEEN -90 AND 90),
    CONSTRAINT chk_orders_lon CHECK (delivery_lon BETWEEN -180 AND 180)
);

CREATE INDEX IF NOT EXISTS idx_orders_customer_created ON orders (customer_id, created_at DESC);
CREATE INDEX IF NOT EXISTS idx_orders_restaurant_status ON orders (restaurant_id, status);
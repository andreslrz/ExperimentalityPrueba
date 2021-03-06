PGDMP                          y            clothesstore    12.5    12.5 <    T           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            U           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            V           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            W           1262    16393    clothesstore    DATABASE     �   CREATE DATABASE clothesstore WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Colombia.1252' LC_CTYPE = 'Spanish_Colombia.1252';
    DROP DATABASE clothesstore;
                postgres    false            �            1259    16484    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    16394    sq_categoria    SEQUENCE     u   CREATE SEQUENCE public.sq_categoria
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.sq_categoria;
       public          postgres    false            �            1259    16396    sq_descuento_producto    SEQUENCE     ~   CREATE SEQUENCE public.sq_descuento_producto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.sq_descuento_producto;
       public          postgres    false            �            1259    16398    sq_imagenes_producto    SEQUENCE     }   CREATE SEQUENCE public.sq_imagenes_producto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.sq_imagenes_producto;
       public          postgres    false            �            1259    16400    sq_precios_producto    SEQUENCE     |   CREATE SEQUENCE public.sq_precios_producto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.sq_precios_producto;
       public          postgres    false            �            1259    16402    sq_producto    SEQUENCE     t   CREATE SEQUENCE public.sq_producto
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.sq_producto;
       public          postgres    false            �            1259    16493    tb_categoria    TABLE     n   CREATE TABLE public.tb_categoria (
    id integer NOT NULL,
    descripcion character varying(30) NOT NULL
);
     DROP TABLE public.tb_categoria;
       public         heap    postgres    false            �            1259    16491    tb_categoria_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_categoria_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.tb_categoria_id_seq;
       public          postgres    false    209            X           0    0    tb_categoria_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.tb_categoria_id_seq OWNED BY public.tb_categoria.id;
          public          postgres    false    208            �            1259    16503    tb_descuento_producto    TABLE     �   CREATE TABLE public.tb_descuento_producto (
    id bigint NOT NULL,
    producto bigint NOT NULL,
    descuento double precision NOT NULL,
    inicio_vigencia date NOT NULL,
    fin_vigencia date NOT NULL
);
 )   DROP TABLE public.tb_descuento_producto;
       public         heap    postgres    false            �            1259    16501    tb_descuento_producto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_descuento_producto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.tb_descuento_producto_id_seq;
       public          postgres    false    211            Y           0    0    tb_descuento_producto_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.tb_descuento_producto_id_seq OWNED BY public.tb_descuento_producto.id;
          public          postgres    false    210            �            1259    16511    tb_imagenes_producto    TABLE     �   CREATE TABLE public.tb_imagenes_producto (
    id bigint NOT NULL,
    producto bigint NOT NULL,
    ruta character varying(2000) NOT NULL
);
 (   DROP TABLE public.tb_imagenes_producto;
       public         heap    postgres    false            �            1259    16509    tb_imagenes_producto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_imagenes_producto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.tb_imagenes_producto_id_seq;
       public          postgres    false    213            Z           0    0    tb_imagenes_producto_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.tb_imagenes_producto_id_seq OWNED BY public.tb_imagenes_producto.id;
          public          postgres    false    212            �            1259    16522    tb_precios_producto    TABLE     �   CREATE TABLE public.tb_precios_producto (
    id bigint NOT NULL,
    producto bigint NOT NULL,
    precio double precision NOT NULL,
    inicio_vigencia date NOT NULL,
    fin_vigencia date NOT NULL
);
 '   DROP TABLE public.tb_precios_producto;
       public         heap    postgres    false            �            1259    16520    tb_precios_producto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_precios_producto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.tb_precios_producto_id_seq;
       public          postgres    false    215            [           0    0    tb_precios_producto_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.tb_precios_producto_id_seq OWNED BY public.tb_precios_producto.id;
          public          postgres    false    214            �            1259    16530    tb_producto    TABLE     8  CREATE TABLE public.tb_producto (
    id bigint NOT NULL,
    nombre character varying(30) NOT NULL,
    fecha_creacion date NOT NULL,
    stock integer NOT NULL,
    categoria integer NOT NULL,
    activo boolean NOT NULL,
    descripcion character varying(500),
    numero_visitas bigint DEFAULT 0 NOT NULL
);
    DROP TABLE public.tb_producto;
       public         heap    postgres    false            �            1259    16528    tb_producto_id_seq    SEQUENCE     {   CREATE SEQUENCE public.tb_producto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.tb_producto_id_seq;
       public          postgres    false    217            \           0    0    tb_producto_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.tb_producto_id_seq OWNED BY public.tb_producto.id;
          public          postgres    false    216            �            1259    16614 
   tb_usuario    TABLE     f  CREATE TABLE public.tb_usuario (
    id bigint NOT NULL,
    apellido1 character varying(30) NOT NULL,
    apellido2 character varying(30),
    contrasena character varying(50) NOT NULL,
    documento character varying(12) NOT NULL,
    nombre1 character varying(30) NOT NULL,
    nombre2 character varying(30),
    usuario character varying(30) NOT NULL
);
    DROP TABLE public.tb_usuario;
       public         heap    postgres    false            �
           2604    16496    tb_categoria id    DEFAULT     r   ALTER TABLE ONLY public.tb_categoria ALTER COLUMN id SET DEFAULT nextval('public.tb_categoria_id_seq'::regclass);
 >   ALTER TABLE public.tb_categoria ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208    209            �
           2604    16506    tb_descuento_producto id    DEFAULT     �   ALTER TABLE ONLY public.tb_descuento_producto ALTER COLUMN id SET DEFAULT nextval('public.tb_descuento_producto_id_seq'::regclass);
 G   ALTER TABLE public.tb_descuento_producto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    210    211            �
           2604    16514    tb_imagenes_producto id    DEFAULT     �   ALTER TABLE ONLY public.tb_imagenes_producto ALTER COLUMN id SET DEFAULT nextval('public.tb_imagenes_producto_id_seq'::regclass);
 F   ALTER TABLE public.tb_imagenes_producto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    213    213            �
           2604    16525    tb_precios_producto id    DEFAULT     �   ALTER TABLE ONLY public.tb_precios_producto ALTER COLUMN id SET DEFAULT nextval('public.tb_precios_producto_id_seq'::regclass);
 E   ALTER TABLE public.tb_precios_producto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            �
           2604    16533    tb_producto id    DEFAULT     p   ALTER TABLE ONLY public.tb_producto ALTER COLUMN id SET DEFAULT nextval('public.tb_producto_id_seq'::regclass);
 =   ALTER TABLE public.tb_producto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            H          0    16493    tb_categoria 
   TABLE DATA           7   COPY public.tb_categoria (id, descripcion) FROM stdin;
    public          postgres    false    209   gF       J          0    16503    tb_descuento_producto 
   TABLE DATA           g   COPY public.tb_descuento_producto (id, producto, descuento, inicio_vigencia, fin_vigencia) FROM stdin;
    public          postgres    false    211   �F       L          0    16511    tb_imagenes_producto 
   TABLE DATA           B   COPY public.tb_imagenes_producto (id, producto, ruta) FROM stdin;
    public          postgres    false    213   �F       N          0    16522    tb_precios_producto 
   TABLE DATA           b   COPY public.tb_precios_producto (id, producto, precio, inicio_vigencia, fin_vigencia) FROM stdin;
    public          postgres    false    215   G       P          0    16530    tb_producto 
   TABLE DATA           x   COPY public.tb_producto (id, nombre, fecha_creacion, stock, categoria, activo, descripcion, numero_visitas) FROM stdin;
    public          postgres    false    217   pG       Q          0    16614 
   tb_usuario 
   TABLE DATA           p   COPY public.tb_usuario (id, apellido1, apellido2, contrasena, documento, nombre1, nombre2, usuario) FROM stdin;
    public          postgres    false    218   �G       ]           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);
          public          postgres    false    207            ^           0    0    sq_categoria    SEQUENCE SET     :   SELECT pg_catalog.setval('public.sq_categoria', 2, true);
          public          postgres    false    202            _           0    0    sq_descuento_producto    SEQUENCE SET     D   SELECT pg_catalog.setval('public.sq_descuento_producto', 1, false);
          public          postgres    false    203            `           0    0    sq_imagenes_producto    SEQUENCE SET     C   SELECT pg_catalog.setval('public.sq_imagenes_producto', 1, false);
          public          postgres    false    204            a           0    0    sq_precios_producto    SEQUENCE SET     B   SELECT pg_catalog.setval('public.sq_precios_producto', 1, false);
          public          postgres    false    205            b           0    0    sq_producto    SEQUENCE SET     :   SELECT pg_catalog.setval('public.sq_producto', 1, false);
          public          postgres    false    206            c           0    0    tb_categoria_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.tb_categoria_id_seq', 11, true);
          public          postgres    false    208            d           0    0    tb_descuento_producto_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.tb_descuento_producto_id_seq', 1, false);
          public          postgres    false    210            e           0    0    tb_imagenes_producto_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.tb_imagenes_producto_id_seq', 4, true);
          public          postgres    false    212            f           0    0    tb_precios_producto_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.tb_precios_producto_id_seq', 3, true);
          public          postgres    false    214            g           0    0    tb_producto_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.tb_producto_id_seq', 11, true);
          public          postgres    false    216            �
           2606    16500 )   tb_categoria tb_categoria_descripcion_key 
   CONSTRAINT     k   ALTER TABLE ONLY public.tb_categoria
    ADD CONSTRAINT tb_categoria_descripcion_key UNIQUE (descripcion);
 S   ALTER TABLE ONLY public.tb_categoria DROP CONSTRAINT tb_categoria_descripcion_key;
       public            postgres    false    209            �
           2606    16498    tb_categoria tb_categoria_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tb_categoria
    ADD CONSTRAINT tb_categoria_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.tb_categoria DROP CONSTRAINT tb_categoria_pkey;
       public            postgres    false    209            �
           2606    16508 0   tb_descuento_producto tb_descuento_producto_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.tb_descuento_producto
    ADD CONSTRAINT tb_descuento_producto_pkey PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.tb_descuento_producto DROP CONSTRAINT tb_descuento_producto_pkey;
       public            postgres    false    211            �
           2606    16519 .   tb_imagenes_producto tb_imagenes_producto_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_imagenes_producto
    ADD CONSTRAINT tb_imagenes_producto_pkey PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.tb_imagenes_producto DROP CONSTRAINT tb_imagenes_producto_pkey;
       public            postgres    false    213            �
           2606    16527 ,   tb_precios_producto tb_precios_producto_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.tb_precios_producto
    ADD CONSTRAINT tb_precios_producto_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.tb_precios_producto DROP CONSTRAINT tb_precios_producto_pkey;
       public            postgres    false    215            �
           2606    16537 "   tb_producto tb_producto_nombre_key 
   CONSTRAINT     _   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT tb_producto_nombre_key UNIQUE (nombre);
 L   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT tb_producto_nombre_key;
       public            postgres    false    217            �
           2606    16535    tb_producto tb_producto_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT tb_producto_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT tb_producto_pkey;
       public            postgres    false    217            �
           2606    16618    tb_usuario tb_usuario_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tb_usuario
    ADD CONSTRAINT tb_usuario_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.tb_usuario DROP CONSTRAINT tb_usuario_pkey;
       public            postgres    false    218            �
           2606    16569 (   tb_descuento_producto fktb_descuen726995    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_descuento_producto
    ADD CONSTRAINT fktb_descuen726995 FOREIGN KEY (producto) REFERENCES public.tb_producto(id);
 R   ALTER TABLE ONLY public.tb_descuento_producto DROP CONSTRAINT fktb_descuen726995;
       public          postgres    false    211    217    2748            �
           2606    16564 '   tb_imagenes_producto fktb_imagene879352    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_imagenes_producto
    ADD CONSTRAINT fktb_imagene879352 FOREIGN KEY (producto) REFERENCES public.tb_producto(id);
 Q   ALTER TABLE ONLY public.tb_imagenes_producto DROP CONSTRAINT fktb_imagene879352;
       public          postgres    false    217    213    2748            �
           2606    16559 &   tb_precios_producto fktb_precios862164    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_precios_producto
    ADD CONSTRAINT fktb_precios862164 FOREIGN KEY (producto) REFERENCES public.tb_producto(id);
 P   ALTER TABLE ONLY public.tb_precios_producto DROP CONSTRAINT fktb_precios862164;
       public          postgres    false    215    217    2748            �
           2606    16554    tb_producto fktb_product730194    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT fktb_product730194 FOREIGN KEY (categoria) REFERENCES public.tb_categoria(id);
 H   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT fktb_product730194;
       public          postgres    false    217    209    2738            H   A   x�3���<�1��˘ӷ4+�(��˒�#?7�(��Ѐ�199�8�(3���А�?-��Ȍ���� #�~      J      x������ � �      L   5   x�3�44�t���I��/�H-..�/J����MLO-��zY�\&�D*����� EI      N   F   x�u�A�@��B����f=9MBBX������r�(���{�艬���~c=�\H^��      P   V   x�3�(�O)M.�Wp�4202�50�52�440�4�,A�5�@p��*v*64@�]�v�Fp�*v��2DR�W�+�1W� a�9      Q      x������ � �     
PGDMP                         z         	   AnimalApp    14.4    14.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16394 	   AnimalApp    DATABASE     h   CREATE DATABASE "AnimalApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "AnimalApp";
                postgres    false            �            1259    16424    animals    TABLE     �   CREATE TABLE public.animals (
    id integer,
    typeid integer,
    dateofborn date,
    name character varying,
    type character varying
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    16419    animaltypes    TABLE     P   CREATE TABLE public.animaltypes (
    id integer,
    name character varying
);
    DROP TABLE public.animaltypes;
       public         heap    postgres    false            �            1259    16404    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    16429    links    TABLE     Z   CREATE TABLE public.links (
    user_id integer,
    animal_id integer,
    id integer
);
    DROP TABLE public.links;
       public         heap    postgres    false            �            1259    16408    users    TABLE     k   CREATE TABLE public.users (
    id integer,
    login character varying,
    password character varying
);
    DROP TABLE public.users;
       public         heap    postgres    false            �          0    16424    animals 
   TABLE DATA           E   COPY public.animals (id, typeid, dateofborn, name, type) FROM stdin;
    public          postgres    false    212   j       �          0    16419    animaltypes 
   TABLE DATA           /   COPY public.animaltypes (id, name) FROM stdin;
    public          postgres    false    211   �       �          0    16429    links 
   TABLE DATA           7   COPY public.links (user_id, animal_id, id) FROM stdin;
    public          postgres    false    213          �          0    16408    users 
   TABLE DATA           4   COPY public.users (id, login, password) FROM stdin;
    public          postgres    false    210   -       �           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 34, true);
          public          postgres    false    209            �   (   x�36�4�4202�50�5���H,���L�O����� mC�      �   V   x��9� ����p�.6A$.$����rF�FO�M
[��,;��͎=�#�� ���~}qȝ+8���Q��Zp��P+'�kC��q�      �      x�3�46�46����� ��      �   S   x�3�ˬJ,J1��4 .s8ߐ���؄˂�1%73�3DrYrz�g�A�8s2�3R��|SN�̜�Ĝ�DNsss�=... Ť=     
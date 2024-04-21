import React, { useState, useEffect } from 'react';
import { Title, Text, Anchor, Container, Button } from '@mantine/core';
import classes from './Test.module.css';
import { HeaderMegaMenu } from '../components/HeaderMegaMenu/HeaderMegaMenu';
import { NavbarNested } from '../components/NavbarNested/NavbarNested';

export function Test() {
  const [products, setProducts] = useState([]);
  const [cart, setCart] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await fetch('http://localhost:8080/products/getAll');
        if (!response.ok) throw new Error('Failed to fetch');
        const data = await response.json();
        setProducts(data);
      } catch (error) {
        setError(error.message);
      } finally {
        setLoading(false);
      }
    };

    fetchProducts();
  }, []);

  const addToCart = async (product) => {
    try {
      const url = new URL('http://localhost:8080/orderProducts/insertOP');
      const params = { productId: product.id, orderId: 1, amount: 1 };  // Assuming orderId is 1 for the example
      url.search = new URLSearchParams(params).toString();

      const response = await fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
      });

      if (!response.ok) {
        throw new Error(`Failed to add product to cart, status: ${response.status}`);
      }

      const addedProduct = await response.json();
      setCart((currentCart) => [...currentCart, addedProduct]);
      alert("Product added to cart successfully!");
    } catch (error) {
      console.error('Error adding product to cart:', error);
      alert("Failed to add product to cart.");
    }
  };

  if (loading) return <p>Loading products...</p>;
  if (error) return <p>Error loading products: {error}</p>;

  return (
    <>
      <Title className={classes.title} ta="center" mt={100}>
        Pharma{' '}
        <Text inherit variant="gradient" component="span" gradient={{ from: 'pink', to: 'yellow' }}>
          Me
        </Text>
      </Title>
      <HeaderMegaMenu />
      <Container size="sm" style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
        <table style={{ width: '100%', textAlign: 'center' }}>
          <thead>
            <tr>
              <th>Name</th>
              <th>Description</th>
              <th>Price</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {products.map((product, index) => (
              <tr key={index}>
                <td>{product.name}</td>
                <td>{product.description}</td>
                <td>${product.price}</td>
                <td>
                  <Button onClick={() => addToCart(product)}>Add to Cart</Button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </Container>
      <Text color="dimmed" ta="center" size="lg" maw={580} mx="auto" mt="xl">
        {' '}
        <Anchor href="https://mantine.dev/guides/next/" size="lg">
          this guide
        </Anchor>
      </Text>
    </>
  );
}

export default Test;

import React, { useState, useEffect } from 'react';
import { Title, Text, Anchor, Button, Table } from '@mantine/core';
import classes from './Test.module.css';
import { HeaderMegaMenu } from '../components/HeaderMegaMenu/HeaderMegaMenu';
import { NavbarNested } from '../components/NavbarNested/NavbarNested';

export function Cart() {
  const [cartItems, setCartItems] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchCartItems();
  }, []);

  const fetchCartItems = async () => {
    try {
      const response = await fetch('http://localhost:8080/orderProducts/order-products?orderId=1');
      if (!response.ok) throw new Error('Failed to fetch cart items');
      const data = await response.json();
      setCartItems(data);
    } catch (error) {
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };
  
  const deleteCartItem = async (id) => {
    try {
      const response = await fetch(`http://localhost:8080/orderProducts/deleteById?id=${id}`, { method: 'DELETE' });
      if (!response.ok) throw new Error('Failed to delete cart item');
      fetchCartItems();  // Refresh cart items after deletion
    } catch (error) {
      console.error('Error deleting cart item:', error);
    }
  };

  if (loading) return <p>Loading cart...</p>;
  if (error) return <p>Error loading cart: {error}</p>;

  return (
    <>
      <Title className={classes.title} ta="center" mt={100}>
        Pharma{' '}
        <Text inherit variant="gradient" component="span" gradient={{ from: 'pink', to: 'yellow' }}>
          Me
        </Text>
      </Title>
      <HeaderMegaMenu />
    
      <Table striped>
        <thead>
          <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {cartItems.map((item) => (
            <tr key={item.id}>
              <td style={{ textAlign: 'center' }}>{item.product.name}</td>
              <td>{item.product.name}</td>
              <td>{item.quantity}</td>
              <td><Button onClick={() => deleteCartItem(item.id)}>Remove</Button></td>
            </tr>
          ))}
        </tbody>
      </Table>
      <Text color="dimmed" ta="center" size="lg" maw={580} mx="auto" mt="xl">
        Manage your cart items above.
      </Text>
    </>
  );
}

export default Cart;
